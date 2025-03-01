package com.klip.petcare.dto.response;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class OwnerResponseDTO {


    private String id;
    private String document;
    private String names;
    private String surnames;
    private String email;
    private String phone;
    private String address;
    private String photo;
}
