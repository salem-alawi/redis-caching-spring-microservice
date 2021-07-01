package com.salemalawi.coursemanagementservice.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DateAudit {


    @Column(name = "CREATED_AT")
    private LocalDateTime createAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updateAt;

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @PrePersist
    public void setCreateAt() {
        this.createAt = LocalDateTime.now();
        this.updateAt = this.createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    @PreUpdate
    public void setUpdateAt() {
        this.updateAt = LocalDateTime.now();

    }


}
