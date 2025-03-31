package com.klip.petcare.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PackageRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 5, max = 15, message = "El título debe tener entre 5 y 15 caracteres")
    private String title;

    @NotNull(message = "Las horas no pueden ser nulas")
    @Min(value = 1, message = "Las horas deben ser al menos 1")
    private BigDecimal hours;
}