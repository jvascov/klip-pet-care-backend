package com.klip.petcare.dto.response;

import com.klip.petcare.entity.core.PetEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DaycareResponseDTO {

    private Integer id;
    private PetResponseDTO pet;
    private PackageResponseDTO packages;
    private BigDecimal leftHours;
    private BigDecimal additionalHours;
    private String status;
}
