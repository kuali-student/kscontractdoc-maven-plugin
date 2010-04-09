
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jan 21 10:05:23 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getRelatedLuiIdsByLuiId", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRelatedLuiIdsByLuiId", namespace = "http://student.kuali.org/wsdl/lu", propOrder = {"luiId","luLuRelationType"})

public class GetRelatedLuiIdsByLuiId {

    @XmlElement(name = "luiId")
    private java.lang.String luiId;
    @XmlElement(name = "luLuRelationType")
    private java.lang.String luLuRelationType;

    public java.lang.String getLuiId() {
        return this.luiId;
    }

    public void setLuiId(java.lang.String newLuiId)  {
        this.luiId = newLuiId;
    }

    public java.lang.String getLuLuRelationType() {
        return this.luLuRelationType;
    }

    public void setLuLuRelationType(java.lang.String newLuLuRelationType)  {
        this.luLuRelationType = newLuLuRelationType;
    }

}
