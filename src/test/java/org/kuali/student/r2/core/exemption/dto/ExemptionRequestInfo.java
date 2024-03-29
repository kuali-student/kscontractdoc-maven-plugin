/**
 * Copyright 2004-2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.r2.core.exemption.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.contract.model.test.source.IdEntityInfo;
import org.kuali.student.r2.core.exemption.infc.ExemptionRequest;
import org.kuali.student.r2.core.exemption.infc.DateOverride;
import org.kuali.student.r2.core.exemption.infc.LearningResultOverride;
import org.kuali.student.r2.core.exemption.infc.MilestoneOverride;

import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExemptionRequestInfo", propOrder = {"id", "typeKey",
    "stateKey", "name", "descr", "processKey", "checkKey",
    "personId",
    "requesterId", "requestDate",
    "approvedByPersonId", "approvedDate",
    "dateOverride", "milestoneOverride",
    "learningResultOverride", "meta", "attributes", "_futureElements"})
public class ExemptionRequestInfo extends IdEntityInfo implements ExemptionRequest, Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement
    private String processKey;
    @XmlElement
    private String checkKey;
    @XmlElement
    private String personId;
    @XmlElement
    private String requesterId;
    @XmlElement
    private Date requestDate;
    @XmlElement
    private String approvedByPersonId;
    @XmlElement
    private Date approvedDate;
    @XmlElement
    private DateOverrideInfo dateOverrideInfo;
    @XmlElement
    private MilestoneOverrideInfo milestoneOverrideInfo;
    @XmlElement
    private LearningResultOverrideInfo learningResultOverrideInfo;
    @XmlAnyElement
    private List<Element> _futureElements;

    public ExemptionRequestInfo() {
        super();
    }

    /**
     * Constructs a new ExemptionRequestInfo from another 
     * ExemptionRequest.
     * 
     * @param exemption the ExemptionRequest to copy
     */
    public ExemptionRequestInfo(ExemptionRequest request) {
        super(request);
        if (null != request) {
            this.processKey = request.getProcessKey();
            this.checkKey = request.getCheckKey();
            this.personId = request.getPersonId();
            this.requesterId = request.getRequesterId();
            this.requestDate = request.getRequestDate();
            this.approvedByPersonId = request.getApprovedByPersonId();
            this.approvedDate = request.getApprovedDate();

            if (request.getDateOverride() != null) {
                this.dateOverrideInfo = new DateOverrideInfo(request.getDateOverride());
            }

            if (request.getMilestoneOverride() != null) {
                this.milestoneOverrideInfo = new MilestoneOverrideInfo(request.getMilestoneOverride());
            }

            if (request.getLearningResultOverride() != null) {
                this.learningResultOverrideInfo = new LearningResultOverrideInfo(request.getLearningResultOverride());
            }
        }

        _futureElements = null;
    }

    @Override
    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    @Override
    public String getCheckKey() {
        return checkKey;
    }

    public void setCheckKey(String checkKey) {
        this.checkKey = checkKey;
    }

    @Override
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    @Override
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String getApprovedByPersonId() {
        return approvedByPersonId;
    }

    public void setApprovedByPersonId(String approvedByPersonId) {
        this.approvedByPersonId = approvedByPersonId;
    }

    @Override
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    @Override
    public DateOverrideInfo getDateOverride() {
        return dateOverrideInfo;
    }

    public void setDateOverride(DateOverrideInfo dateOverrideInfo) {
        this.dateOverrideInfo = dateOverrideInfo;
    }

    @Override
    public MilestoneOverrideInfo getMilestoneOverride() {
        return milestoneOverrideInfo;
    }

    public void setMilestoneOverride(MilestoneOverrideInfo milestoneOverrideInfo) {
        this.milestoneOverrideInfo = milestoneOverrideInfo;
    }

    @Override
    public LearningResultOverrideInfo getLearningResultOverride() {
        return learningResultOverrideInfo;
    }

    public void setLearningResultOverride(LearningResultOverrideInfo learningResultOverrideInfo) {
        this.learningResultOverrideInfo = learningResultOverrideInfo;
    }
}
