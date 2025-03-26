package com.klip.petcare.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PetResponseDTO {

    private Integer id;
    private String name;
    private String gender;
    private String species;
    private String color;
    private String size;
    private String breed;
    private String owner;
}
