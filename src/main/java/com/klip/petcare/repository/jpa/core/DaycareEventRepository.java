package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.DaycareEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaycareEventRepository extends JpaRepository<DaycareEventEntity, Integer> {
}
