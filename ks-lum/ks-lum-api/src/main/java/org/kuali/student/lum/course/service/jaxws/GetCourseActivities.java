
package org.kuali.student.lum.course.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Tue May 18 13:33:13 PDT 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getCourseActivities", namespace = "http://student.kuali.org/wsdl/course")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCourseActivities", namespace = "http://student.kuali.org/wsdl/course")

public class GetCourseActivities {

    @XmlElement(name = "formatId")
    private java.lang.String formatId;

    public java.lang.String getFormatId() {
        return this.formatId;
    }

    public void setFormatId(java.lang.String newFormatId)  {
        this.formatId = newFormatId;
    }

}
