
package org.kuali.student.core.statement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Wed May 12 12:54:47 PDT 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getRefStatementRelationType", namespace = "http://student.kuali.org/wsdl/statement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRefStatementRelationType", namespace = "http://student.kuali.org/wsdl/statement")

public class GetRefStatementRelationType {

    @XmlElement(name = "refStatementRelationTypeKey")
    private java.lang.String refStatementRelationTypeKey;

    public java.lang.String getRefStatementRelationTypeKey() {
        return this.refStatementRelationTypeKey;
    }

    public void setRefStatementRelationTypeKey(java.lang.String newRefStatementRelationTypeKey)  {
        this.refStatementRelationTypeKey = newRefStatementRelationTypeKey;
    }

}
