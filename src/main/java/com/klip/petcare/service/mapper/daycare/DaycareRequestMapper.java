package com.klip.petcare.service.mapper.daycare;

import com.klip.petcare.dto.request.DaycareRequestDTO;
import com.klip.petcare.entity.core.DaycareEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DaycareRequestMapper {

    @Mapping(source = "pet", target = "pet.id")
    @Mapping(source = "packages", target = "packages.id")
    @Mapping(source = "leftHours", target = "leftHours")
    @Mapping(source = "additionalHours", target = "additionalHours")
    @Mapping(source = "status", target = "status")
    DaycareEntity toEntity(DaycareRequestDTO dto);

    @Mapping(source = "pet.id", target = "pet")
    @Mapping(source = "packages.id", target = "packages")
    @Mapping(source = "leftHours", target = "leftHours")
    @Mapping(source = "additionalHours", target = "additionalHours")
    @Mapping(source = "status", target = "status")
    DaycareRequestDTO toDTO(DaycareEntity entity);
}

