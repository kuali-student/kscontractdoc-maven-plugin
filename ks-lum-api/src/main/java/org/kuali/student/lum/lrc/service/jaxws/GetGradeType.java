
package org.kuali.student.lum.lrc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Wed Apr 22 09:59:25 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getGradeType", namespace = "http://student.kuali.org/wsdl/lrc")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGradeType", namespace = "http://student.kuali.org/wsdl/lrc")

public class GetGradeType {

    @XmlElement(name = "gradeTypeKey")
    private java.lang.String gradeTypeKey;

    public java.lang.String getGradeTypeKey() {
        return this.gradeTypeKey;
    }

    public void setGradeTypeKey(java.lang.String newGradeTypeKey)  {
        this.gradeTypeKey = newGradeTypeKey;
    }

}

