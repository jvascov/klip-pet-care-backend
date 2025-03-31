package com.klip.petcare.service.mapper.pet;

import com.klip.petcare.dto.response.PetResponseDTO;
import com.klip.petcare.entity.core.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface PetResponseMapper {


    //@Mapping(source = "id", target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "species", target = "species")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "breed", target = "breed")
    @Mapping(source = "owner", target = "owner")
    //@Mapping(source = "photoUrl", target = "photoUrl")
    PetEntity toEntity(PetResponseDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "species", target = "species")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "breed", target = "breed")
    @Mapping(source = "owner", target = "owner")
    //@Mapping(source = "photoUrl", target = "photoUrl")
    PetResponseDTO toDTO(PetEntity entity);
}
