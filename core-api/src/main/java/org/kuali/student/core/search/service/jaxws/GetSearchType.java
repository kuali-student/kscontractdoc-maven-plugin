
package org.kuali.student.core.search.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.1.3
 * Tue Jan 27 08:59:03 EST 2009
 * Generated source version: 2.1.3
 */

@XmlRootElement(name = "getSearchType", namespace = "http://org.kuali.student/core/organization")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSearchType", namespace = "http://org.kuali.student/core/organization")

public class GetSearchType {

    @XmlElement(name = "searchTypeKey")
    private java.lang.String searchTypeKey;

    public java.lang.String getSearchTypeKey() {
        return this.searchTypeKey;
    }

    public void setSearchTypeKey(java.lang.String newSearchTypeKey)  {
        this.searchTypeKey = newSearchTypeKey;
    }

}

