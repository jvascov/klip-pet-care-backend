package com.klip.petcare.repository.jpa.core;

import com.klip.petcare.entity.core.PetEntity;
import com.klip.petcare.repository.jpa.base.GenericRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends GenericRepository<PetEntity, Integer> {

    @Query("SELECT  p FROM PetEntity p WHERE p.status = 'ACTIVE'")
    List<PetEntity> findAllPets ();

    @Query("SELECT p FROM PetEntity p WHERE p.id = :id")
    Optional<PetEntity> findPetById (@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE PetEntity p SET " +
            "p.name = :#{#pet.name}, " +
            "p.gender = :#{#pet.gender}, " +
            "p.species = :#{#pet.species}, " +
            "p.color = :#{#pet.color}, " +
            "p.size = :#{#pet.size}, " +
            "p.breed = :#{#pet.breed}, " +
            "p.owner = :#{#pet.owner}, " +
            "p.photoUrl = :#{#pet.photoUrl}, " +
            "p.status = :#{#pet.status} " +
            "WHERE p.id = :#{#pet.id}")
    PetEntity update(@Param("pet") PetEntity pet);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE PETS p SET p.ESTADO = 'DISABLED' WHERE p.STATUS = 'ACTIVE' AND p.ID = :id")
    void deletePetById(@Param("id") Integer id);
}
