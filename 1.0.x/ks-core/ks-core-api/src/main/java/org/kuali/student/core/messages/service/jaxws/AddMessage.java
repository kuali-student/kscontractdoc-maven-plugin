
package org.kuali.student.core.messages.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Feb 26 11:02:03 EST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "addMessage", namespace = "http://student.kuali.org/wsdl/messages")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addMessage", namespace = "http://student.kuali.org/wsdl/messages")

public class AddMessage {

    @XmlElement(name = "messageInfo")
    private org.kuali.student.core.messages.dto.Message messageInfo;

    public org.kuali.student.core.messages.dto.Message getMessageInfo() {
        return this.messageInfo;
    }

    public void setMessageInfo(org.kuali.student.core.messages.dto.Message newMessageInfo)  {
        this.messageInfo = newMessageInfo;
    }

}
