package com.klip.petcare.service.mapper;

import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface OwnerResponseMapper {

    OwnerEntity toEntity(OwnerResponseDTO dto);

    OwnerResponseDTO toDto(OwnerEntity entity);
}
