
package org.kuali.student.brms.rulemanagement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Tue Apr 07 16:13:12 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "updateBusinessRule", namespace = "http://student.kuali.org/wsdl/brms/RuleManagement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateBusinessRule", namespace = "http://student.kuali.org/wsdl/brms/RuleManagement", propOrder = {"businessRuleId","businessRuleInfo"})

public class UpdateBusinessRule {

    @XmlElement(name = "businessRuleId")
    private java.lang.String businessRuleId;
    @XmlElement(name = "businessRuleInfo")
    private org.kuali.student.brms.rulemanagement.dto.BusinessRuleInfo businessRuleInfo;

    public java.lang.String getBusinessRuleId() {
        return this.businessRuleId;
    }

    public void setBusinessRuleId(java.lang.String newBusinessRuleId)  {
        this.businessRuleId = newBusinessRuleId;
    }

    public org.kuali.student.brms.rulemanagement.dto.BusinessRuleInfo getBusinessRuleInfo() {
        return this.businessRuleInfo;
    }

    public void setBusinessRuleInfo(org.kuali.student.brms.rulemanagement.dto.BusinessRuleInfo newBusinessRuleInfo)  {
        this.businessRuleInfo = newBusinessRuleInfo;
    }

}
