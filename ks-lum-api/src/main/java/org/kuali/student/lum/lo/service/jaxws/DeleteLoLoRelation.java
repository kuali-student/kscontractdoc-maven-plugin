
package org.kuali.student.lum.lo.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Feb 19 15:17:58 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "deleteLoLoRelation", namespace = "http://student.kuali.org/wsdl/lo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteLoLoRelation", namespace = "http://student.kuali.org/wsdl/lo")

public class DeleteLoLoRelation {

    @XmlElement(name = "loLoRelationId")
    private java.lang.String loLoRelationId;

    public java.lang.String getLoLoRelationId() {
        return this.loLoRelationId;
    }

    public void setLoLoRelationId(java.lang.String newLoLoRelationId)  {
        this.loLoRelationId = newLoLoRelationId;
    }

}
