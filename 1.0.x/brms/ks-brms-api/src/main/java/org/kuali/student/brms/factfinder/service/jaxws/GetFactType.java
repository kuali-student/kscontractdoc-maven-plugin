
package org.kuali.student.brms.factfinder.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Tue Apr 07 16:16:41 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getFactType", namespace = "http://student.kuali.org/wsdl/brms/FactFinder")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFactType", namespace = "http://student.kuali.org/wsdl/brms/FactFinder")

public class GetFactType {

    @XmlElement(name = "factTypeKey")
    private java.lang.String factTypeKey;

    public java.lang.String getFactTypeKey() {
        return this.factTypeKey;
    }

    public void setFactTypeKey(java.lang.String newFactTypeKey)  {
        this.factTypeKey = newFactTypeKey;
    }

}

