
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

@XmlRootElement(name = "getLuLuRelationTypeInfoResponse", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLuLuRelationTypeInfoResponse", namespace = "http://student.kuali.org/wsdl/lu")

public class GetLuLuRelationTypeInfoResponse {

    @XmlElement(name = "return")
    private org.kuali.student.lum.lu.dto.LuLuRelationTypeInfo _return;

    public org.kuali.student.lum.lu.dto.LuLuRelationTypeInfo getReturn() {
        return this._return;
    }

    public void setReturn(org.kuali.student.lum.lu.dto.LuLuRelationTypeInfo new_return)  {
        this._return = new_return;
    }

}

