package com.klip.petcare.entity.core;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqOwner")
    @SequenceGenerator(sequenceName = "SQ_OWNER", allocationSize = 1, name = "sqOwner")
    private Integer id;

    @Column(name = "DOCUMENT", nullable = false)
    private String document;

    @Column(name = "STATUS", length = 15)
    @Size(max = 15, min = 3, message = "Size not allowed")
    private String status ;
}
