package com.klip.petcare.entity.core;

import com.klip.petcare.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DAYCARE_EVENTS")
@Entity(name = "DaycareEventEntity")
public class DaycareEventEntity extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqDaycareEvent")
    @SequenceGenerator(sequenceName = "SQ_DAYCARE_EVENT", allocationSize = 1, name = "sqDaycareEvent")
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "daycare", referencedColumnName = "ID", nullable = false)
    private DaycareEntity daycare;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "TOTAL_HOURS")
    private Double totalHours;
}
