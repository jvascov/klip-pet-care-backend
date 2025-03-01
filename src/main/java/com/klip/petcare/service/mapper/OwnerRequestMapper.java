package com.klip.petcare.service.mapper;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface OwnerRequestMapper {

    //@Mapping(target = "id", ignore = true)
    OwnerEntity toEntity(OwnerRequestDTO ownerRequestDTO);

    OwnerRequestDTO toDto(OwnerEntity ownerEntity);
}
