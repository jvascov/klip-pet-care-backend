package com.klip.petcare.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OwnerResponseDTO {


    //private String id;
    private String document;
    private String names;
    private String surnames;
    private String email;
    private String phone;
    private String address;
}
