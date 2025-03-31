package com.klip.petcare.service.mapper.event;

import com.klip.petcare.dto.response.EventResponseDTO;
import com.klip.petcare.entity.core.EventEntity;
import com.klip.petcare.service.mapper.daycare.DaycareResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DaycareResponseMapper.class)
public interface EventResponseMapper {

    @Mapping(source = "daycare", target = "daycare")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "totalHours", target = "totalHours")
    EventResponseDTO toDto(EventEntity eventEntity);

    @Mapping(source = "daycare", target = "daycare")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "totalHours", target = "totalHours")
    EventEntity toEntity(EventResponseDTO eventResponseDTO);
}
