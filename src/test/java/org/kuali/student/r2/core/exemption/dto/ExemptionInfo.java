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
import org.kuali.student.r2.core.exemption.infc.Exemption;
import org.kuali.student.r2.core.exemption.infc.DateOverride;
import org.kuali.student.r2.core.exemption.infc.LearningResultOverride;
import org.kuali.student.r2.core.exemption.infc.MilestoneOverride;

import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExemptionInfo", propOrder = {"id", "typeKey", "stateKey", 
                "name", "descr", "exemptionRequestId",
                "exemptedPersonId", "effectiveDate", "expirationDate", 
                "useLimit", "useCount", "dateOverride", "milestoneOverride",
                "learningResultOverride", "meta", "attributes", "_futureElements"})
public class ExemptionInfo extends IdEntityInfo implements Exemption, Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement
    private String exemptionRequestId;

    @XmlElement
    private String exemptedPersonId;

    @XmlElement
    private Date effectiveDate;

    @XmlElement
    private Date expirationDate;

    @XmlElement
    private Integer useLimit;

    @XmlElement
    private Integer useCount;

    @XmlElement
    private DateOverrideInfo dateOverrideInfo;

    @XmlElement
    private MilestoneOverrideInfo milestoneOverrideInfo;

    @XmlElement
    private LearningResultOverrideInfo learningResultOverrideInfo;

    @XmlAnyElement
    private List<Element> _futureElements;

    public ExemptionInfo() {
        super();
    }

    /**
     * Constructs a new ExemptionInfo from another Exemption.
     * 
     * @param exemption
     *            the Exemption to copy
     */
    public ExemptionInfo(Exemption exemption) {
        super(exemption);

        if (null != exemption) {
            this.exemptionRequestId = exemption.getExemptionRequestId();
            this.exemptedPersonId = exemption.getExemptedPersonId();
            this.effectiveDate = exemption.getEffectiveDate();
            this.expirationDate = exemption.getExpirationDate();
            this.useLimit = exemption.getUseLimit();
            this.useCount = exemption.getUseCount();

            if (exemption.getDateOverride() != null) {
                this.dateOverrideInfo = new DateOverrideInfo(exemption.getDateOverride());
            }

            if (exemption.getMilestoneOverride() != null) {
                this.milestoneOverrideInfo = new MilestoneOverrideInfo(exemption.getMilestoneOverride());
            }

            if (exemption.getLearningResultOverride() != null) {
                this.learningResultOverrideInfo = new LearningResultOverrideInfo(exemption.getLearningResultOverride());
            }
        }

        _futureElements = null;
    }

    @Override
    public String getExemptionRequestId() {
        return exemptionRequestId;
    }

    public void setExemptionRequestId(String exemptionRequestId) {
        this.exemptionRequestId = exemptionRequestId;
    }

    @Override
    public String getExemptedPersonId() {
        return exemptedPersonId;
    }

    public void setExemptedPersonId(String exemptedPersonId) {
        this.exemptedPersonId = exemptedPersonId;
    }

    @Override
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public Integer getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(Integer useLimit) {
        this.useLimit = useLimit;
    }

    @Override
    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    @Override
    public DateOverrideInfo getDateOverride() {
        return dateOverrideInfo;
    }

    public void setDateOverride(DateOverrideInfo dateOverrideInfo) {
        this.dateOverrideInfo = new DateOverrideInfo(dateOverrideInfo);
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
