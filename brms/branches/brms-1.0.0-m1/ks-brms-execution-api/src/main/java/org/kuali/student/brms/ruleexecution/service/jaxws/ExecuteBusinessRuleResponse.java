
package org.kuali.student.brms.ruleexecution.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Mon Jul 13 20:40:00 PDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "executeBusinessRuleResponse", namespace = "http://student.kuali.org/wsdl/brms/RuleExecution")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeBusinessRuleResponse", namespace = "http://student.kuali.org/wsdl/brms/RuleExecution")

public class ExecuteBusinessRuleResponse {

    @XmlElement(name = "return")
    private org.kuali.student.brms.ruleexecution.dto.ExecutionResultInfo _return;

    public org.kuali.student.brms.ruleexecution.dto.ExecutionResultInfo getReturn() {
        return this._return;
    }

    public void setReturn(org.kuali.student.brms.ruleexecution.dto.ExecutionResultInfo new_return)  {
        this._return = new_return;
    }

}

