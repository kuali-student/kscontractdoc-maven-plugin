
package org.kuali.student.brms.repository.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Mon Jul 13 20:53:46 PDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "createState", namespace = "http://student.kuali.org/wsdl/brms/RuleRepository")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createState", namespace = "http://student.kuali.org/wsdl/brms/RuleRepository")

public class CreateState {

    @XmlElement(name = "name")
    private java.lang.String name;

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String newName)  {
        this.name = newName;
    }

}
