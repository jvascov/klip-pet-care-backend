package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.base.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends GenericRepository<OwnerEntity, Integer> {
}
