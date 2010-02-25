/*
 * Copyright 2010 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.service.proposal.dev.api;


import java.util.Date;
import java.util.Map;


public interface ProposalDocRelationInfo
{
	
	/**
	* Set Proposal Identifier
	*
	* Unique identifier for a Proposal.
	*/
	public void setProposalId(String proposalId);
	
	/**
	* Get Proposal Identifier
	*
	* Unique identifier for a Proposal.
	*/
	public String getProposalId();
	
	
	
	/**
	* Set Document Identifier
	*
	* Unique identifier for a document.
	*/
	public void setDocumentId(String documentId);
	
	/**
	* Get Document Identifier
	*
	* Unique identifier for a document.
	*/
	public String getDocumentId();
	
	
	
	/**
	* Set Document Title
	*
	* The title of the document usage in the context of the Proposal.
	*/
	public void setTitle(String title);
	
	/**
	* Get Document Title
	*
	* The title of the document usage in the context of the Proposal.
	*/
	public String getTitle();
	
	
	
	/**
	* Set Document Description
	*
	* The description of the document usage in the context of the Proposal.
	*/
	public void setDesc(RichTextInfo desc);
	
	/**
	* Get Document Description
	*
	* The description of the document usage in the context of the Proposal.
	*/
	public RichTextInfo getDesc();
	
	
	
	/**
	* Set Effective Date
	*
	* Date and time that this Proposal Doc Relation became effective. This is a 
	* similar concept to the effective date on enumerated values. When an expiration 
	* date has been specified, this field must be less than or equal to the expiration 
	* date.
	*/
	public void setEffectiveDate(Date effectiveDate);
	
	/**
	* Get Effective Date
	*
	* Date and time that this Proposal Doc Relation became effective. This is a 
	* similar concept to the effective date on enumerated values. When an expiration 
	* date has been specified, this field must be less than or equal to the expiration 
	* date.
	*/
	public Date getEffectiveDate();
	
	
	
	/**
	* Set Expiration Date
	*
	* Date and time that this Proposal Doc Relation expires. This is a similar concept 
	* to the expiration date on enumerated values. If specified, this should be 
	* greater than or equal to the effective date. If this field is not specified, 
	* then no expiration date has been currently defined and should automatically be 
	* considered greater than the effective date.
	*/
	public void setExpirationDate(Date expirationDate);
	
	/**
	* Get Expiration Date
	*
	* Date and time that this Proposal Doc Relation expires. This is a similar concept 
	* to the expiration date on enumerated values. If specified, this should be 
	* greater than or equal to the effective date. If this field is not specified, 
	* then no expiration date has been currently defined and should automatically be 
	* considered greater than the effective date.
	*/
	public Date getExpirationDate();
	
	
	
	/**
	* Set Generic/dynamic attributes
	*
	* List of key/value pairs, typically used for dynamic attributes.
	*/
	public void setAttributes(Map<String,String> attributes);
	
	/**
	* Get Generic/dynamic attributes
	*
	* List of key/value pairs, typically used for dynamic attributes.
	*/
	public Map<String,String> getAttributes();
	
	
	
	/**
	* Set Create/Update meta info
	*
	* Create and last update info for the structure. This is optional and treated as 
	* read only since the data is set by the internals of the service during 
	* maintenance operations.
	*/
	public void setMetaInfo(MetaInfo metaInfo);
	
	/**
	* Get Create/Update meta info
	*
	* Create and last update info for the structure. This is optional and treated as 
	* read only since the data is set by the internals of the service during 
	* maintenance operations.
	*/
	public MetaInfo getMetaInfo();
	
	
	
	/**
	* Set Proposal Document Relation Type Key
	*
	* Unique identifier for a proposal document relation type. Describes the type of 
	* usage of the document.
	*/
	public void setType(String type);
	
	/**
	* Get Proposal Document Relation Type Key
	*
	* Unique identifier for a proposal document relation type. Describes the type of 
	* usage of the document.
	*/
	public String getType();
	
	
	
	/**
	* Set Proposal Document Relation State Key
	*
	* The current status of the Proposal to document relationship. The values for this 
	* field are constrained to those in the proposalDocRelationState enumeration. A 
	* separate setup operation does not exist for retrieval of the meta data around 
	* this value.
	*/
	public void setState(String state);
	
	/**
	* Get Proposal Document Relation State Key
	*
	* The current status of the Proposal to document relationship. The values for this 
	* field are constrained to those in the proposalDocRelationState enumeration. A 
	* separate setup operation does not exist for retrieval of the meta data around 
	* this value.
	*/
	public String getState();
	
	
	
	/**
	* Set Proposal Document Relation Identifier
	*
	* Unique identifier for a proposal to document relation. This is optional, due to 
	* the identifier being set at the time of creation. Once the connection has been 
	* created, this should be seen as required.
	*/
	public void setId(String id);
	
	/**
	* Get Proposal Document Relation Identifier
	*
	* Unique identifier for a proposal to document relation. This is optional, due to 
	* the identifier being set at the time of creation. Once the connection has been 
	* created, this should be seen as required.
	*/
	public String getId();
	
	
	
}

