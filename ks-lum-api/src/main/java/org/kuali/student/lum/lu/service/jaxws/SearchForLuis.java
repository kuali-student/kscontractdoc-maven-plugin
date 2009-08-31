
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.1.4
 * Tue Feb 24 12:25:30 EST 2009
 * Generated source version: 2.1.4
 */

@XmlRootElement(name = "searchForLuis", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchForLuis", namespace = "http://student.kuali.org/wsdl/lu")

public class SearchForLuis {

    @XmlElement(name = "luiCriteria")
    private org.kuali.student.lum.lu.dto.LuiCriteriaInfo luiCriteria;

    public org.kuali.student.lum.lu.dto.LuiCriteriaInfo getLuiCriteria() {
        return this.luiCriteria;
    }

    public void setLuiCriteria(org.kuali.student.lum.lu.dto.LuiCriteriaInfo newLuiCriteria)  {
        this.luiCriteria = newLuiCriteria;
    }

}

