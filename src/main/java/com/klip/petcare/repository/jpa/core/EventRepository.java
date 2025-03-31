package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.DaycareEntity;
import com.klip.petcare.entity.core.EventEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    Optional<EventEntity> findEventEntityByDaycareAndStatus(DaycareEntity daycare, String status);
}
