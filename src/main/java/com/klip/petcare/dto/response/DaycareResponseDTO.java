package com.klip.petcare.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DaycareResponseDTO {

    private Integer id;
    private Integer pet;
    private Integer packages;
    private Double leftHours;
    private Double additionalHours;
    private String status;
}
