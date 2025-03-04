package com.klip.petcare.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class GenericEntity {

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;


}
