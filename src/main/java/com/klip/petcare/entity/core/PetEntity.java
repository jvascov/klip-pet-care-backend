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
@Table(name = "PETS")
@Entity(name = "PetEntity")
@EqualsAndHashCode(callSuper = false)
public class PetEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqPet")
    @SequenceGenerator(sequenceName = "SQ_PET", allocationSize = 1, initialValue = 1, name = "sqPet")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", length = 50, nullable = false)
    @Size(max = 20, min = 3)
    private String name;

    @Column(name = "GENDER", length = 10, nullable = false)
    @Size(max = 10, min = 4)
    private String gender;

    @Column(name = "SPECIES", length = 20, nullable = false)
    @Size(max = 20, min = 4)
    private String species;

    @Column(name = "COLOR", length = 20, nullable = false)
    @Size(max = 20, min = 4)
    private String color;

    @Column(name = "PET_SIZE", length = 20)
    @Size(max = 20, min = 4)
    private String size;

    @Column(name = "BREED", length = 20, nullable = false)
    @Size(max = 20, min = 4)
    private String breed;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "DOCUMENT", nullable = false)
    private OwnerEntity owner;

    @Column(name = "PHOTO", length = 1000)
    private String photoUrl;
}
