/*
 * Copyright 2007 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.brms.repository.exceptions;

/**
 * This is the rule engine repository exception class. 
 * 
 * @author Kuali Student Team (len.kuali@googlegroups.com)
 *
 */
public class RuleEngineRepositoryException extends RuntimeException {
    
    /** Class serial version uid */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new rule engine exception.
     * 
     * @param cause Cause of this exception
     */
    public RuleEngineRepositoryException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new rule engine exception.
     * 
     * @param msg Error message description
     * @param cause Cause of this exception
     */
    public RuleEngineRepositoryException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs a new rule engine exception.
     * 
     * @param msg Error message description
     */
    public RuleEngineRepositoryException(String msg) {
        super(msg);
    }
}