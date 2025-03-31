package com.klip.petcare.service.mapper.event;

import com.klip.petcare.dto.request.EventRequestDTO;
import com.klip.petcare.entity.core.EventEntity;
import com.sun.jdi.request.EventRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {

    @Mapping(source = "daycare", target = "daycare.id")
    EventEntity toEntity(EventRequestDTO eventRequest);

    @Mapping(source = "daycare.id", target = "daycare")
    EventRequestDTO toDto(EventEntity eventEntity);
}
