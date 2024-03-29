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
package org.kuali.student.contract.model.test.source;

/**
 *
 * @author nwright
 */
public interface HasKey extends HasPrimaryKey {

    /**
     * Unique key to this object. Unlike an Id this key can be explicitly set by the
     * application and is intended to be "somewhat" readable by a human.
     *
     * A Key:<ul>
     * <li>A Key is used when the actual value is important
     * <li>A Key value might be kuali.org.School
     * <li>A Key on occasion may be used or seen by an end user.
     * <li>Keys are assumed to have the same values in different KS implementations
     * <li>Key values are defined in configuration
     * <li>Key values have significance in that they are referenced in Configuration
     * <li>Key values are expected to be occasionally used in application code
     * </ul>
     * @name Unique Key
     * @readOnly after create
     * @required
     */
    public String getKey();
}
