package com.klip.petcare.service.mapper;

import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface OwnerResponseMapper {

    //@Mapping(source = "id", target = "id", ignore = true)
    @Mapping(source = "document", target = "document")
    @Mapping(source = "names", target = "names")
    @Mapping(source = "surnames", target = "surnames")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    OwnerEntity toEntity(OwnerResponseDTO dto);

    //@Mapping(source = "id", target = "id", ignore = true)
    @Mapping(source = "document", target = "document")
    @Mapping(source = "names", target = "names")
    @Mapping(source = "surnames", target = "surnames")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    OwnerResponseDTO toDto(OwnerEntity entity);
}
