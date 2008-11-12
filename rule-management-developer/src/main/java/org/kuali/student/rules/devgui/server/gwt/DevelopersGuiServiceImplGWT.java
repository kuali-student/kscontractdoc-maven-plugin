/**
 * 
 */
package org.kuali.student.rules.devgui.server.gwt;

import java.util.List;

import org.kuali.student.core.spring.BeanFactory;
import org.kuali.student.rules.devgui.client.model.RuleTypesHierarchyInfo;
import org.kuali.student.rules.devgui.client.model.RulesHierarchyInfo;
import org.kuali.student.rules.devgui.client.service.DevelopersGuiService;
import org.kuali.student.rules.devgui.server.impl.DevelopersGuiServiceImpl;
import org.kuali.student.rules.rulemanagement.dto.BusinessRuleInfoDTO;
import org.kuali.student.rules.rulemanagement.dto.BusinessRuleTypeDTO;
import org.kuali.student.rules.rulemanagement.dto.StatusDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author zzraly
 */
public class DevelopersGuiServiceImplGWT extends RemoteServiceServlet implements DevelopersGuiService {

    private static final long serialVersionUID = 822326113643828855L;

    private final DevelopersGuiService serviceImpl = (DevelopersGuiService) BeanFactory.getInstance().getBean("developersGuiService");


    public String createBusinessRule(BusinessRuleInfoDTO businessRuleInfo) {
        return serviceImpl.createBusinessRule(businessRuleInfo);
    }

    public StatusDTO updateBusinessRule(String businessRuleId, BusinessRuleInfoDTO businessRuleInfo) {
        return serviceImpl.updateBusinessRule(businessRuleId, businessRuleInfo);
    }

    public BusinessRuleInfoDTO fetchDetailedBusinessRuleInfo(String ruleId) {
        return serviceImpl.fetchDetailedBusinessRuleInfo(ruleId);
    }

    public BusinessRuleTypeDTO fetchBusinessRuleType(String ruleTypeKey, String anchorTypeKey) {
        return serviceImpl.fetchBusinessRuleType(ruleTypeKey, anchorTypeKey);
    }

    public String testBusinessRule(String businessRuleId) {
        return serviceImpl.testBusinessRule(businessRuleId);
    }

    public List<String> findAgendaTypes() {
    	return serviceImpl.findAgendaTypes();
    }
    
    public List<String> findBusinessRuleTypesByAgendaType(String agendaTypeKey) {
    	return serviceImpl.findBusinessRuleTypesByAgendaType(agendaTypeKey);
    }
    
    public List<RulesHierarchyInfo> findRulesHierarchyInfo() {
        return serviceImpl.findRulesHierarchyInfo();
    }

    public List<RuleTypesHierarchyInfo> findRuleTypesHierarchyInfo() {
        return serviceImpl.findRuleTypesHierarchyInfo();
    }    
    
    /**
     * @return the serviceImpl
     */
    public DevelopersGuiService getServiceImpl() {
        return serviceImpl;
    }

    /**
     * @param serviceImpl
     *            the serviceImpl to set
     */
    public void setServiceImpl(DevelopersGuiServiceImpl serviceImpl) {
    // this.serviceImpl = serviceImpl;
    }
}
