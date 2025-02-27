package com.klip.petcare.entity.core;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OWNERS")
@Entity(name = "OwnerEntity")
public class OwnerEntity extends PersonEntity {

    @Id
    @Column(name = "DOCUMENT", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqOwner")
    @SequenceGenerator(sequenceName = "SQ_OWNER", allocationSize = 1, name = "sqOwner")
    private String document;
}
