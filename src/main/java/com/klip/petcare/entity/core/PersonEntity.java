package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class PersonEntity extends GenericEntity {

    @Column(name = "DOCUMENT", length = 20, nullable = false)
    @Size(max = 12, min = 8)
    private String docNumber;

    @Column(name = "NAMES", length = 50, nullable = false)
    @Size(max = 20, min = 8)
    private String names;

    @Column(name = "SURNAMES", length = 50, nullable = false)
    @Size(max = 20, min = 5)
    private String surnames;

    @Column(name = "EMAIL", length = 100, nullable = false)
    @Size(max = 20, min = 8)
    private String email;

    @Column(name = "PHONE", length = 20, nullable = false)
    @Size(max = 15, min = 8)
    private String phone;

    @Column(name = "ADDRESS", length = 30)
    @Size(max = 20, min = 8)
    private String address;

}
