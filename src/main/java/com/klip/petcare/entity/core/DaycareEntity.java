package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "DAYCARES")
@Entity(name = "DaycareEntity")
public class DaycareEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqDaycare")
    @SequenceGenerator(sequenceName = "SQ_DAYCARE", allocationSize = 1, name = "sqDaycare")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PET", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "PACKAGE", referencedColumnName = "ID", nullable = false)
    private PackageEntity packages;

    @Column(name = "LEFT_HOURS")
    private BigDecimal leftHours;

    @Column(name = "ADDITIONAL_HOURS")
    private Double additionalHours;

    @Column(name = "STATUS")
    private String status;

}
