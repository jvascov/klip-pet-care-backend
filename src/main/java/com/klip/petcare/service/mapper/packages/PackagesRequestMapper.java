package com.klip.petcare.service.mapper.packages;

import com.klip.petcare.dto.request.PackageRequestDTO;
import com.klip.petcare.entity.core.PackageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PackagesRequestMapper {

    @Mapping(target = "id", ignore = true)
    PackageEntity toEntity(PackageRequestDTO dto);
}
