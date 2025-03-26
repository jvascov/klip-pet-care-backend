package com.klip.petcare.service.core.pet;

import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.PetRequestDTO;
import com.klip.petcare.dto.response.PetResponseDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.entity.core.PetEntity;
import com.klip.petcare.repository.jpa.core.OwnerRepository;
import com.klip.petcare.repository.jpa.core.PetRepository;
import com.klip.petcare.service.mapper.pet.PetRequestMapper;
import com.klip.petcare.service.mapper.pet.PetResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {


    private final PetRepository petRepository;
    private final PetRequestMapper petRequestMapper;
    private final PetResponseMapper petResponseMapper;
    private final OwnerRepository ownerRepository;


    @Override
    public List<PetResponseDTO> findAll() throws PetException {

        List<PetResponseDTO> petList = petRepository.findAllPets().stream().map(
                petResponseMapper::toDTO).toList();
        if (petList.isEmpty()) {
            throw new PetException("No pets found");
        }

        return petList;
    }

    @Override
    public PetResponseDTO findById(Integer id) throws PetException {

        return petResponseMapper.toDTO(petRepository.findPetById(id).orElseThrow(() -> new PetException("Pet not found")));
    }

    @Override
    public Integer save(PetRequestDTO petRequestDTO) throws NotContentException {

        OwnerEntity owner = ownerRepository.findByDocument(petRequestDTO.getOwner()).orElseThrow(() -> new NotContentException("Owner not found"));

        PetEntity tempPet = petRequestMapper.toEntity(petRequestDTO);
        tempPet.setOwner(owner);
        tempPet.setStatus("ACTIVE");

        PetEntity pet = petRepository.save(tempPet);

        return pet.getId();
    }

    @Override
    public PetResponseDTO update(PetRequestDTO dto, Integer id) {

        return petResponseMapper.toDTO( petRepository.update(petRequestMapper.toEntity(dto)));

    }

    @Override
    public void delete(Integer id) throws PetException {
        petRepository.deletePetById(id);
    }
}
