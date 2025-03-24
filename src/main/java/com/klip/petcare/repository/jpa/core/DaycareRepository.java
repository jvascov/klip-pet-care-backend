package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.DaycareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DaycareRepository extends JpaRepository<DaycareEntity, Integer> {

    @Query("SELECT  p FROM DaycareEntity p WHERE p.pet.id = :pet AND p.status = 'IN_PROGRESS'")
    Optional<DaycareEntity> findActiveDaycare(Integer pet);
}
