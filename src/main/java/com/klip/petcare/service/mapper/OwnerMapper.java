package com.klip.petcare.service.mapper;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface OwnerMapper {

    OwnerEntity toEntity(OwnerRequestDTO ownerRequestDTO);

    OwnerRequestDTO toDto(OwnerEntity ownerEntity);
}
