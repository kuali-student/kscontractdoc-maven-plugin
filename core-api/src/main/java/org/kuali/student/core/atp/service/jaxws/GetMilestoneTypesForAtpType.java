
package org.kuali.student.core.atp.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Tue Mar 31 14:06:06 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getMilestoneTypesForAtpType", namespace = "http://student.kuali.org/core/atp")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMilestoneTypesForAtpType", namespace = "http://student.kuali.org/core/atp")

public class GetMilestoneTypesForAtpType {

    @XmlElement(name = "atpTypeKey")
    private java.lang.String atpTypeKey;

    public java.lang.String getAtpTypeKey() {
        return this.atpTypeKey;
    }

    public void setAtpTypeKey(java.lang.String newAtpTypeKey)  {
        this.atpTypeKey = newAtpTypeKey;
    }

}

