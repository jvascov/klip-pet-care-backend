package com.klip.petcare.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OwnerDTORequest {

    @NotBlank(message = "docNumber is required")
    @Size(min = 8, max = 20, message = "docNumber must have between 8 and 20 characters")
    @NotNull(message = "docNumber cannot be null")
    private String docNumber;

    @NotBlank(message = "names is required")
    @Size(min = 8, max = 20, message = "names must have between 8 and 12 characters")
    @NotNull(message = "names cannot be null")
    private String names;

    @NotBlank(message = "surnames is required")
    @Size(min = 5, max = 20, message = "surnames must have between 5 and 20 characters")
    @NotNull(message = "surnames cannot be null")
    private String surnames;

    @NotBlank(message = "email is required")
    @Size(min = 8, max = 20, message = "email must have between 8 and 20 characters")
    @Email(message = "email is not valid")
    @NotNull(message = "email cannot be null")
    private String email;

    @NotBlank(message = "phone is required")
    @NotNull(message = "phone cannot be null")
    private String phone;

    private String address;
}
