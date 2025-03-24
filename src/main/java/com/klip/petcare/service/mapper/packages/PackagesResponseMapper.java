package com.klip.petcare.service.mapper.packages;

import com.klip.petcare.dto.response.PackageResponseDTO;
import com.klip.petcare.entity.core.PackageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackagesResponseMapper {

    PackageResponseDTO toDTO(PackageEntity entity);
}
