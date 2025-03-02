package com.klip.petcare.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class GenericEntity {

    @Column(name = "STATUS", length = 10)
    @Size(max = 10, min = 3, message = "Size not allowed")
    protected String status;

    @CreatedDate
    @Column(name = "CREATED_AT")
    protected LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;


}
