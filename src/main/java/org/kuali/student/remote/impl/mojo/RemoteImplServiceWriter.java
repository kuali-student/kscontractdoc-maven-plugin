/*
 * Copyright 2009 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.remote.impl.mojo;

import java.util.ArrayList;
import java.util.List;
import org.kuali.student.contract.model.Service;

import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.ServiceMethod;
import org.kuali.student.contract.model.ServiceMethodError;
import org.kuali.student.contract.model.ServiceMethodParameter;
import org.kuali.student.contract.model.XmlType;
import org.kuali.student.contract.model.util.ModelFinder;
import org.kuali.student.contract.writer.JavaClassWriter;
import org.kuali.student.contract.writer.service.GetterSetterNameCalculator;
import org.kuali.student.contract.writer.service.MessageStructureTypeCalculator;
import org.kuali.student.contract.writer.service.ServiceExceptionWriter;

/**
 *
 * @author nwright
 */
public class RemoteImplServiceWriter extends JavaClassWriter {

    private ServiceContractModel model;
    private ModelFinder finder;
    private String directory;
    private String rootPackage;
    private String servKey;
    private List<ServiceMethod> methods;

    public RemoteImplServiceWriter(ServiceContractModel model,
            String directory,
            String rootPackage,
            String servKey,
            List<ServiceMethod> methods) {
        super(directory, calcPackage(servKey, rootPackage), calcClassName(servKey));
        this.model = model;
        this.finder = new ModelFinder(model);
        this.directory = directory;
        this.rootPackage = rootPackage;
        this.servKey = servKey;
        this.methods = methods;
    }

    public static String calcPackage(String servKey, String rootPackage) {
//        String pack = rootPackage + "." + servKey.toLowerCase() + ".";
//  StringBuffer buf = new StringBuffer (service.getVersion ().length ());
//  for (int i = 0; i < service.getVersion ().length (); i ++)
//  {
//   char c = service.getVersion ().charAt (i);
//   c = Character.toLowerCase (c);
//   if (Character.isLetter (c))
//   {
//    buf.append (c);
//    continue;
//   }
//   if (Character.isDigit (c))
//   {
//    buf.append (c);
//   }
//  }
//  pack = pack + buf.toString ();
//        pack = pack + "service.decorators";
//        return pack;
        return rootPackage;
    }

    public static String calcClassName(String servKey) {
        return GetterSetterNameCalculator.calcInitUpper(servKey + "ServiceRemoteImpl");
    }

    public static String calcDecoratorClassName(String servKey) {
        return GetterSetterNameCalculator.calcInitUpper(servKey + "ServiceDecorator");
    }

    private static enum MethodType {

        VALIDATE, CREATE, UPDATE
    };

    private MethodType calcMethodType(ServiceMethod method) {
        if (method.getName().startsWith("validate")) {
            return MethodType.VALIDATE;
        }
        if (method.getName().startsWith("create")) {
            return MethodType.CREATE;
        }
        if (method.getName().startsWith("update")) {
            return MethodType.UPDATE;
        }
        return null;
    }

    /**
     * Write out the entire file
     *
     * @param out
     */
    public void write() {
        indentPrint("public class " + calcClassName(servKey));
        println(" extends " + calcDecoratorClassName(servKey));
        // TODO: figure out how to add import for the decorator
        openBrace();
        writeHostUrlGetterSetter();

        indentPrintln("//");
        indentPrintln("// Have to override and check for null because of a bug in CXF 2.3.8 our current version");
        indentPrintln("// It was fixed in 2.6.1 but 2.3.8 still renders empty lists as null when transported by soap");
        indentPrintln("// see http://stackoverflow.com/questions/11384986/apache-cxf-web-services-problems");
        indentPrintln("//");
        for (ServiceMethod method : methods) {
            if (!method.getReturnValue().getType().endsWith("List")) {
                continue;
            }

            indentPrintln("");
//            indentPrintln("/**");
//            indentPrintWrappedComment(method.getDescription());
//            indentPrintln("* ");
//            for (ServiceMethodParameter param : method.getParameters()) {
//                indentPrintWrappedComment("@param " + param.getName() + " - "
//                        + param.getType() + " - "
//                        + param.getDescription());
//            }
//            indentPrintWrappedComment("@return " + method.getReturnValue().
//                    getDescription());
//            indentPrintln("*/");
            indentPrintln("@Override");
            String type = method.getReturnValue().getType();
            String realType = stripList(type);
            indentPrint("public " + calcType(type, realType) + " " + method.getName()
                    + "(");
            // now do parameters
            String comma = "";
            for (ServiceMethodParameter param : method.getParameters()) {
                type = param.getType();
                realType = stripList(type);
                print(comma);
                print(calcType(type, realType));
                print(" ");
                print(param.getName());
                comma = ", ";
            }
            println(")");
            // now do exceptions
            comma = "throws ";
            incrementIndent();
            for (ServiceMethodError error : method.getErrors()) {
                indentPrint(comma);
                String exceptionClassName = calcExceptionClassName(error);
                String exceptionPackageName = this.calcExceptionPackageName(error);
                println(exceptionClassName);
                this.importsAdd(exceptionPackageName + "." + exceptionClassName);
                comma = "      ,";
            }
            decrementIndent();
            openBrace();
            type = method.getReturnValue().getType();
            realType = stripList(type);
            XmlType retValXmlType = finder.findXmlType(realType);
            importsAdd(retValXmlType.getJavaPackage() + "." + retValXmlType.getName());
            indentPrint("List<" + retValXmlType.getName() + "> list = this.getNextDecorator ()." + method.getName() + "(");
            comma = "";
            for (ServiceMethodParameter param : method.getParameters()) {
                type = param.getType();
                realType = stripList(type);
                print(comma);
                print(param.getName());
                comma = ", ";
            }
            println(");");
            indentPrintln("if (list == null)");
            openBrace();
            importsAdd(ArrayList.class.getName());
            indentPrintln("return new ArrayList<" + retValXmlType.getName() + "> ();");
            closeBrace();
            indentPrintln("return list;");
            closeBrace();
        }
        closeBrace();

        this.writeJavaClassAndImportsOutToFile();
        this.getOut().close();
    }

    private String calcType(String type, String realType) {
        XmlType t = finder.findXmlType(this.stripList(type));
        return MessageStructureTypeCalculator.calculate(this, model, type, realType,
                t.getJavaPackage());
    }

    private String stripList(String str) {
        return GetterSetterNameCalculator.stripList(str);
    }

    private String calcExceptionClassName(ServiceMethodError error) {
        if (error.getClassName() == null) {
            return ServiceExceptionWriter.calcClassName(error.getType());
        }
        return error.getClassName();
    }

    private String calcExceptionPackageName(ServiceMethodError error) {
        if (error.getClassName() == null) {
            return ServiceExceptionWriter.calcPackage(rootPackage);
        }
        return error.getPackageName();
    }

    private void writeHostUrlGetterSetter() {

        String initUpper = GetterSetterNameCalculator.calcInitUpper(servKey);

        indentPrintln("private String hostUrl;");
        println("");
        indentPrintln("public String getHostUrl()");
        openBrace();
        indentPrintln("return hostUrl;");
        closeBrace();
        indentPrintln("public void setHostUrl(String hostUrl)");
        openBrace();
        indentPrintln("this.hostUrl = hostUrl;");
        indentPrintln("if (hostUrl == null)");
        openBrace();
        indentPrintln("this.setNextDecorator(null);");
        indentPrintln("return;");
        closeBrace();
        indentPrintln("URL wsdlURL;");
        indentPrintln("try");
        openBrace();
        String constantsFile = initUpper + "ServiceConstants";
        // TODO: figure out how to add import for the service constants
        indentPrintln("String urlStr = hostUrl + \"/services/\" + " + constantsFile + ".SERVICE_NAME_LOCAL_PART + \"?wsdl\";");
        indentPrintln("wsdlURL = new URL(urlStr);");
        closeBrace();
        indentPrintln("catch (MalformedURLException ex)");
        openBrace();
        indentPrintln("throw new IllegalArgumentException(ex);");
        closeBrace();

        importsAdd("java.net.MalformedURLException");
        importsAdd("java.net.URL");
        importsAdd("javax.xml.namespace.QName");
        importsAdd("javax.xml.ws.Service");
        Service service = finder.findService(servKey);
        importsAdd(service.getImplProject() + "." + service.getName());

        indentPrintln("QName qname = new QName(" + constantsFile + ".NAMESPACE, " + constantsFile + ".SERVICE_NAME_LOCAL_PART);");
        indentPrintln("Service factory = Service.create(wsdlURL, qname);");
        indentPrintln(service.getName() + " port = factory.getPort(" + service.getName() + ".class);");
        indentPrintln("this.setNextDecorator(port);");
        closeBrace();

    }
}