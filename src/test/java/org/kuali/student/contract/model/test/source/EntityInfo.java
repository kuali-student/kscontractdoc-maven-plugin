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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.kuali.student.contract.model.test.source.Entity;

@SuppressWarnings("serial")
@XmlTransient
public abstract class EntityInfo extends HasAttributesAndMetaInfo implements Entity, Serializable {

    @XmlElement
    private String name;
    @XmlElement
    private RichTextInfo descr;
    @XmlElement(required = true)
    private String typeKey;
    @XmlAttribute(required = true)
    private String stateKey;

    protected EntityInfo() {
        super();
        name = null;
        descr = null;
        typeKey = null;
        stateKey = null;
    }

    protected EntityInfo(Entity builder) {
        super(builder);
        this.name = builder.getName();
        this.descr = builder.getDescr();
        this.typeKey = builder.getTypeKey();
        this.stateKey = builder.getStateKey();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RichTextInfo getDescr() {
        return descr;
    }

    @Override
    public String getTypeKey() {
        return typeKey;
    }

    @Override
    public String getStateKey() {
        return stateKey;
    }

    /**
     * The builder class for this abstract EntityInfo.
     */
    public static class Builder extends HasAttributesAndMetaInfo.Builder implements Entity {

        private String name;
        private RichTextInfo descr;
        private String typeKey;
        private String stateKey;

        public Builder() {
        }

        public Builder(Entity entity) {
            super(entity);
            this.name = entity.getName();
            this.descr = entity.getDescr();
            this.typeKey = entity.getTypeKey();
            this.stateKey = entity.getStateKey();
        }

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public RichTextInfo getDescr() {
            return descr;
        }

        public void setDescr(RichTextInfo descr) {
            this.descr = descr;
        }

        @Override
        public String getTypeKey() {
            return typeKey;
        }

        public void setTypeKey(String typeKey) {
            this.typeKey = typeKey;
        }

        @Override
        public String getStateKey() {
            return stateKey;
        }

        public void setStateKey(String stateKey) {
            this.stateKey = stateKey;
        }
    }
}
