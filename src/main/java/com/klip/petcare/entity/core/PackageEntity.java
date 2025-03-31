package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Table(name = "PACKAGES")
@Entity(name = "PackagesEntity")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackageEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqPackage")
    @SequenceGenerator(sequenceName = "SQ_PACKAGE", allocationSize = 1, name = "sqPackage")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE", nullable = false, length = 30)
    @Size(max = 15, min = 5)
    private String title;

    @Column(name = "HOURS", nullable = false)
    private BigDecimal hours;

}
