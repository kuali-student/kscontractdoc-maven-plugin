/*
 * Copyright 2009 Johnson Consulting Services
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.kuali.student.lum.lu.ui.course.client.widgets.a.dynamictable.export;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Defines an RPC service capable of handling ExportRequests
 * @author wilj
 *
 * @param <T> the generic type with which the table structure is associated
 */
public interface ExportService<T> extends RemoteService {
	/**
	 * Initiates an export
	 * @param request the configuration of the export
	 * @return the export transaction id
	 * @throws ExportException
	 */
	public ExportStatus export(ExportRequest<T> request) throws ExportException;

	/**
	 * Returns the current ExportStatus, which is updated by the asynchronous export process on the server
	 * @param exportId the export transaction id
	 * @return the current ExportStatus, which is updated by the asynchronous export process on the server
	 * @throws ExportException
	 */
	public ExportStatus getExportStatus(String exportId) throws ExportException;
}