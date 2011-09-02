package org.kuali.student.enrollment.class1.lpr.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.kuali.student.enrollment.lpr.dto.LuiPersonRelationInfo;
import org.kuali.student.enrollment.lpr.infc.LuiPersonRelation;
import org.kuali.student.r2.common.dto.AttributeInfo;
import org.kuali.student.r2.common.entity.AttributeOwner;
import org.kuali.student.r2.common.entity.MetaEntity;
import org.kuali.student.r2.common.infc.Attribute;

/**
 * @author Igor
 */
@Entity
@Table(name = "KSEN_LPR")
public class LuiPersonRelationEntity extends MetaEntity implements AttributeOwner<LuiPersonRelationAttributeEntity> {

    private String personId;

    private String luiId;

    private Float commitmentPercent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RELATION_TYPE_ID")
    private LuiPersonRelationTypeEntity personRelationType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RELATION_STATE_ID")
    private LuiPersonRelationStateEntity personRelationState;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    // @JoinColumn(name = "LPR_ATTR_ID")
    // @JoinTable(name="LPR_ATTR_JOIN",
    // joinColumns=@JoinColumn(name="OWNER_ID", referencedColumnName="ID"),
    // inverseJoinColumns=@JoinColumn(name="ATTRIB_ID",
    // referencedColumnName="ID"))
    private List<LuiPersonRelationAttributeEntity> attributes;

    public LuiPersonRelationEntity() {}

    public LuiPersonRelationEntity(LuiPersonRelation dto) {
        super(dto);
        this.setEffectiveDate(dto.getEffectiveDate());
        this.setExpirationDate(dto.getExpirationDate());
        this.setId(dto.getId());
        this.setLuiId(dto.getLuiId());
        this.setPersonId(dto.getPersonId());
        this.setCommitmentPercent(dto.getCommitmentPercent());
        this.setExpirationDate(dto.getExpirationDate());
        this.setEffectiveDate(dto.getEffectiveDate());
        // TODO - need to retrieve the LuiPersonRelationState based on the
        // return of dto.getState()?
        // this.setPersonRelationState(new
        // LuiPersonRelationStateEntity(dto.getStateKey()));
        // TODO - need to retrieve the LuiPersonRelationType based on the return
        // of dto.getType()?
        // this.setPersonRelationType(new
        // LuiPersonRelationTypeEntity(dto.getTypeKey()));
        this.setAttributes(new ArrayList<LuiPersonRelationAttributeEntity>());
        if (null != dto.getAttributes()) {
            for (Attribute att : dto.getAttributes()) {
                this.getAttributes().add(new LuiPersonRelationAttributeEntity(att));
            }
        }
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getLuiId() {
        return luiId;
    }

    public void setLuiId(String luiId) {
        this.luiId = luiId;
    }

    public Float getCommitmentPercent() {
        return commitmentPercent;
    }

    public void setCommitmentPercent(Float commitmentPercent) {
        this.commitmentPercent = commitmentPercent;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LuiPersonRelationTypeEntity getPersonRelationType() {
        return personRelationType;
    }

    public void setPersonRelationType(LuiPersonRelationTypeEntity personRelationType) {
        this.personRelationType = personRelationType;
    }

    public LuiPersonRelationStateEntity getPersonRelationState() {
        return personRelationState;
    }

    public void setPersonRelationState(LuiPersonRelationStateEntity personRelationState) {
        this.personRelationState = personRelationState;
    }

    @Override
    public List<LuiPersonRelationAttributeEntity> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttributes(List<LuiPersonRelationAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public LuiPersonRelationInfo toDto() {
        LuiPersonRelationInfo lprInfo = new LuiPersonRelationInfo();
        lprInfo.setId(getId());
        lprInfo.setLuiId(luiId);
        lprInfo.setCommitmentPercent(commitmentPercent);
        lprInfo.setPersonId(personId);
        lprInfo.setEffectiveDate(effectiveDate);
        lprInfo.setExpirationDate(expirationDate);
        lprInfo.setTypeKey(personRelationType.getId());
        lprInfo.setStateKey(personRelationState.getId());
        lprInfo.setMeta(super.toDTO());
        List<AttributeInfo> atts = new ArrayList<AttributeInfo>();
        for (LuiPersonRelationAttributeEntity att : getAttributes()) {
            AttributeInfo attInfo = att.toDto();
            atts.add(attInfo);
        }
        lprInfo.setAttributes(atts);

        return lprInfo;
    }
}
