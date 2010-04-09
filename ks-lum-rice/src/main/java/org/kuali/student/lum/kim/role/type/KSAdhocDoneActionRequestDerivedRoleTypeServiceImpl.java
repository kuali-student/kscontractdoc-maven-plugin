/**
 * 
 */
package org.kuali.student.lum.kim.role.type;

import java.util.Collections;
import java.util.List;

/**
 * Action Request derived role type to look at Adhoc action requests with a
 * status of DONE where an action taken has already satisfied the request
 * 
 */
public class KSAdhocDoneActionRequestDerivedRoleTypeServiceImpl extends KSAdhocActionRequestDerivedRoleTypeServiceImpl {

	/* (non-Javadoc)
     * @see org.kuali.student.lum.kim.role.type.KSActionRequestDerivedRoleTypeServiceImpl#getRequestStatusesToCheck()
     */
    @Override
    protected List<REQUESTS_STATUS_TO_CHECK> getRequestStatusesToCheck() {
		return Collections.singletonList(REQUESTS_STATUS_TO_CHECK.DONE);
    }

}