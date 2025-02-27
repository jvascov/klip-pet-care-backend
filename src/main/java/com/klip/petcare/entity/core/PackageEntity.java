package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Table(name = "PACKAGES")
@Entity(name = "PackagesEntity")
@EqualsAndHashCode(callSuper = false)
public class PackageEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqPackage")
    @SequenceGenerator(sequenceName = "SQ_PACKAGE", allocationSize = 1, name = "sqPackage")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 30)
    @Size(max = 15, min = 5)
    private String title;

    @Column(name = "HOURS", nullable = false)
    private Double hours;

}
