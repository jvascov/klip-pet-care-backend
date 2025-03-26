package com.klip.petcare.service.core.pet;

import com.klip.petcare.dto.request.PetRequestDTO;
import com.klip.petcare.dto.response.PetResponseDTO;
import com.klip.petcare.service.base.GenericService;

public interface PetService extends GenericService<PetRequestDTO, PetResponseDTO> {
    void delete(Integer id) throws PetException;
}
