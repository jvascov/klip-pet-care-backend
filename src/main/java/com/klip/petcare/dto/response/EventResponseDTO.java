package com.klip.petcare.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EventResponseDTO {

    private Integer id;

    private DaycareResponseDTO daycare;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal totalHours;

    private String status;

}
