
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

@XmlRootElement(name = "getDateRangeType", namespace = "http://student.kuali.org/core/atp")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDateRangeType", namespace = "http://student.kuali.org/core/atp")

public class GetDateRangeType {

    @XmlElement(name = "dateRangeTypeKey")
    private java.lang.String dateRangeTypeKey;

    public java.lang.String getDateRangeTypeKey() {
        return this.dateRangeTypeKey;
    }

    public void setDateRangeTypeKey(java.lang.String newDateRangeTypeKey)  {
        this.dateRangeTypeKey = newDateRangeTypeKey;
    }

}

