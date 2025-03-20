package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.base.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends GenericRepository<OwnerEntity, Integer> {
   Optional<OwnerEntity> findByDocument(String document);
}
