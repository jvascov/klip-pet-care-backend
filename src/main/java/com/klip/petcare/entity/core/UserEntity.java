package com.klip.petcare.entity.core;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
@Entity(name = "UsersEntity")
public class UserEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqUser")
    @SequenceGenerator(sequenceName = "SQ_USER", allocationSize = 1, initialValue = 1, name = "sqUser")
    private Integer id;
}
