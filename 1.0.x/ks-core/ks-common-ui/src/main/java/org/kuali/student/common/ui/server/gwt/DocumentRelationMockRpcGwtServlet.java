/*
 * Copyright 2009 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.common.ui.server.gwt;

import java.util.List;

import org.kuali.student.common.ui.client.service.DocumentRelationMockRpcService;
import org.kuali.student.core.dto.RefDocRelationInfoMock;
import org.kuali.student.core.dto.StatusInfo;
import org.kuali.student.core.mock.service.DocumentRelationService;

public class DocumentRelationMockRpcGwtServlet extends BaseRpcGwtServletAbstract<DocumentRelationService> implements DocumentRelationMockRpcService{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void createRefDocRelation(String refId, String docId, RefDocRelationInfoMock relInfo) throws Exception{
		service.createRefDocRelation(refId, docId, relInfo);
	}

	@Override
	public List<RefDocRelationInfoMock> getRefDocIdsForRef(String id) throws Exception{
		return service.getRefDocIdsForRef(id);
	}

	@Override
	public StatusInfo deleteRefDocRelation(String id) throws Exception {
		// TODO Auto-generated method stub
		return service.deleteRefDocRelation(id);
	}

}