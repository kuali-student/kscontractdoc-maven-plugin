
package org.kuali.student.brms.statement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Tue Jan 26 22:57:16 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "createReqComponent", namespace = "http://student.kuali.org/wsdl/statement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createReqComponent", namespace = "http://student.kuali.org/wsdl/statement", propOrder = {"reqComponentType","reqComponentInfo"})

public class CreateReqComponent {

    @XmlElement(name = "reqComponentType")
    private java.lang.String reqComponentType;
    @XmlElement(name = "reqComponentInfo")
    private org.kuali.student.brms.statement.dto.ReqComponentInfo reqComponentInfo;

    public java.lang.String getReqComponentType() {
        return this.reqComponentType;
    }

    public void setReqComponentType(java.lang.String newReqComponentType)  {
        this.reqComponentType = newReqComponentType;
    }

    public org.kuali.student.brms.statement.dto.ReqComponentInfo getReqComponentInfo() {
        return this.reqComponentInfo;
    }

    public void setReqComponentInfo(org.kuali.student.brms.statement.dto.ReqComponentInfo newReqComponentInfo)  {
        this.reqComponentInfo = newReqComponentInfo;
    }

}

