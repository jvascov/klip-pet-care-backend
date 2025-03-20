package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity extends GenericEntity {

    @Column(name = "NAMES", length = 100, nullable = false)
    @Size(max = 100, min = 2)
    private String names;

    @Column(name = "SURNAMES", length = 100, nullable = false)
    @Size(max = 100, min = 2)
    private String surnames;

    @Column(name = "EMAIL", length = 100, nullable = false)
    @Size(max = 100, min = 2)
    private String email;

    @Column(name = "PHONE", length = 20, nullable = false)
    @Size(max = 15, min = 8)
    private String phone;

    @Column(name = "ADDRESS", length = 100)
    @Size(max = 100, min = 8)
    private String address;

}
