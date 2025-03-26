package com.klip.petcare.dto.request;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DaycareRequestDTO {

    @NotNull(message = "Pet id is required")
    private Integer pet;

    @NotNull(message = "Package Id is required")
    private Integer packages;

    @DecimalMin(value = "0.0", message = "leftHours must be a positive number")
    private Double leftHours;

    private Double additionalHours;

    private String status;

}
