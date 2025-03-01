package com.klip.petcare.service.core;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.service.base.GenericService;
import org.springframework.stereotype.Service;

public interface OwnerService extends GenericService<OwnerRequestDTO, Integer, OwnerResponseDTO> {
}
