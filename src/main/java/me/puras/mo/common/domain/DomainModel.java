package me.puras.mo.common.domain;

import me.puras.mo.common.Constants;
import me.puras.mo.common.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class DomainModel implements Serializable {
    private Long id;
    private Integer deleted = Constants.DEFAULT_DELETED;
    private Long createdBy;
    private Date createdAt;
    private Long updatedBy;
    private Date updatedAt;



    public void defaultValue() {
    }

    public void createDefaultValue() {
        Date now = DateUtils.currentDate();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public void updateDefaultValue() {
        this.setUpdatedAt(DateUtils.currentDate());
    }

    @Override
    public String toString() {
        return "DomainModel{" +
                "id=" + id +
                ", deleted=" + deleted +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedBy=" + updatedBy +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
