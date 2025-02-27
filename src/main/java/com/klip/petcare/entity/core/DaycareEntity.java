package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DAYCARE")
@Entity(name = "DaycareEntity")
public class DaycareEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqDaycare")
    @SequenceGenerator(sequenceName = "SQ_DAYCARE", allocationSize = 1, name = "sqDaycare")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "packages", referencedColumnName = "ID", nullable = false)
    private PackageEntity packages;

    @Column(name = "LEFTHOURS")
    private Double leftHours;

}
