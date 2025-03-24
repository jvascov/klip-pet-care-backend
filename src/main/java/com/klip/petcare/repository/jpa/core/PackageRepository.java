package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {
}
