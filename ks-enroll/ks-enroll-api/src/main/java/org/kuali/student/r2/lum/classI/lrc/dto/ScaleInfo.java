/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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

package org.kuali.student.r2.lum.classI.lrc.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.kuali.student.r2.common.dto.KeyEntityInfo;
import org.kuali.student.r2.common.infc.RichText;
import org.kuali.student.r2.lum.classI.lrc.Scale;

/**
 * Detailed information about a result scale.
 * 
 * @Author sambit
 * @Since
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ScaleInfo extends KeyEntityInfo implements Scale {

	private static final long serialVersionUID = 1L;

	@XmlElement
	private Date effectiveDate;

	@XmlElement
	private Date expirationDate;

	@XmlAttribute
	private String id;

	public ScaleInfo() {

	}

	public ScaleInfo(String name, RichText descr, String key, String typeKey,
			String stateKey, Date effectiveDate, Date expirationDate, String id) {
		// TODO once devs make objects mutable
		super();
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
		this.id = id;
	}

	public ScaleInfo createNewScaleInfoFromScaleInfo(ScaleInfo scaleInfo) {

		return new ScaleInfo(scaleInfo.getName(), scaleInfo.getDescr(),
				scaleInfo.getKey(), scaleInfo.getTypeKey(),
				scaleInfo.getStateKey(), scaleInfo.getEffectiveDate(),
				scaleInfo.getExpirationDate(), scaleInfo.getId());
	}

	/**
	 * Date and time that this scale became effective. This is a similar concept
	 * to the effective date on enumerated values. When an expiration date has
	 * been specified, this field must be less than or equal to the expiration
	 * date.
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Date and time that this scale expires. This is a similar concept to the
	 * expiration date on enumerated values. If specified, this should be
	 * greater than or equal to the effective date. If this field is not
	 * specified, then no expiration date has been currently defined and should
	 * automatically be considered greater than the effective date.
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Unique identifier for a scale.
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
