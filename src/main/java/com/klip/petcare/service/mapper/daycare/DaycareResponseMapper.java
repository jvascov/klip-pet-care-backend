package com.klip.petcare.service.mapper.daycare;

import com.klip.petcare.dto.response.DaycareResponseDTO;
import com.klip.petcare.entity.core.DaycareEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DaycareResponseMapper {

    @Mapping(source = "pet.id", target = "pet")
    @Mapping(source = "packages.id", target = "packages")
    @Mapping(source = "leftHours", target = "leftHours")
    @Mapping(source = "additionalHours", target = "additionalHours")
    @Mapping(source = "status", target = "status")
    DaycareResponseDTO toDTO(DaycareEntity entity);
}
