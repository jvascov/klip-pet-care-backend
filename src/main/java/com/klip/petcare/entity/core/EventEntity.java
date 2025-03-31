package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DAYCARE_EVENTS")
@Entity(name = "EventEntity")
public class EventEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqDaycareEvent")
    @SequenceGenerator(sequenceName = "SQ_DAYCARE_EVENT", allocationSize = 1, name = "sqDaycareEvent")
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "daycare", referencedColumnName = "ID", nullable = false)
    private DaycareEntity daycare;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "TOTAL_HOURS")
    private BigDecimal totalHours;

    @Column(name = "STATUS")
    private String status;
}
