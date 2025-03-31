package com.klip.petcare.service.core.daycare.events;

import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.EventRequestDTO;
import com.klip.petcare.dto.request.EventRequestUpdateDTO;
import com.klip.petcare.dto.response.EventResponseDTO;
import com.klip.petcare.service.base.GenericService;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface EventService extends GenericService<EventRequestDTO, EventResponseDTO> {

    String updateEvent(Integer id) throws NotContentException;
}
