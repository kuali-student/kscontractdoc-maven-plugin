
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.lum.lu.dto.LuiLuiRelationInfo;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jan 21 10:05:23 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getLuiLuiRelationsByLuiResponse", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLuiLuiRelationsByLuiResponse", namespace = "http://student.kuali.org/wsdl/lu")
public class GetLuiLuiRelationsByLuiResponse {

    @XmlElement(name = "return")
    private java.util.List<LuiLuiRelationInfo> _return;

    public java.util.List<LuiLuiRelationInfo> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.List<LuiLuiRelationInfo> new_return)  {
        this._return = new_return;
    }
}
