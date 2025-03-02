package com.klip.petcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PetDTORequest {

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 20, message = "name must have between 3 and 20 characters")
    @NotNull(message = "name cannot be null")
    private String name;

    @NotBlank(message = "gender is required")
    @Size(min = 4, max = 10, message = "gender must have between 4 and 10 characters")
    @NotNull(message = "gender cannot be null")
    private String gender;

    @NotBlank(message = "species is required")
    @Size(min = 4, max = 20, message = "species must have between 4 and 20 characters")
    @NotNull(message = "species cannot be null")
    private String species;

    @NotBlank(message = "color is required")
    @Size(min = 4, max = 20, message = "species must have between 4 and 20 characters")
    @NotNull(message = "color cannot be null")
    private String color;

    @NotBlank(message = "size is required")
    @Size(min = 4, max = 20, message = "size must have between 4 and 20 characters")
    @NotNull(message = "size cannot be null")
    private String size;

    @NotBlank(message = "breed is required")
    @Size(min = 4, max = 20, message = "breed must have between 4 and 20 characters")
    @NotNull(message = "breed cannot be null")
    private String breed;

    @NotBlank(message = "owner is required")
    @Size(min = 4, max = 20, message = "owner must have between 4 and 20 characters")
    @NotNull(message = "owner cannot be null")
    private String owner;
}
