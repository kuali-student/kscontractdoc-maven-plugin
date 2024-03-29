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
package org.kuali.student.r2.core.exemption.infc;

import java.util.List;

/**
 * Information about a LearningResultOverride. A learning result
 * override describes data related to creating new LRRs outside of the
 * normal process.
 *
 * @author tom
 * @since Tue Jun 14 14:22:34 EDT 2011
 */ 
public interface LearningResultOverride {

    /**
     * Name: LRR Ids
     * The Ids of the Learning Result Records created for this result
     * override.
     */
    public List<String> getLrrIds();
}
