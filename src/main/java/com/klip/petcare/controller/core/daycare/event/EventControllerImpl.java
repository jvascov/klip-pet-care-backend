package com.klip.petcare.controller.core.daycare.event;

import com.klip.petcare.controller.base.GenericController;
import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.EventRequestDTO;
import com.klip.petcare.dto.request.EventRequestUpdateDTO;
import com.klip.petcare.dto.response.EventResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.core.daycare.events.EventService;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventControllerImpl extends GenericController implements EventController {

    private final EventService eventService;
    private final HttpServletRequest request;

    public EventControllerImpl(final EventService eventService, final HttpServletRequest request) {
        this.eventService = eventService;
        this.request = request;
    }

    @Override
    public ResponseEntity<CustomResponse> save(EventRequestDTO eventRequest, BindingResult result) throws ControllerException, ServiceException, NotContentException {

        EventResponseDTO response = eventService.save(eventRequest);

        return getResponse(response.getId(), request.getRequestURI());
    }

    @Override
    public ResponseEntity<CustomResponse> findById(Integer id) throws ControllerException, NotContentException {

        EventResponseDTO response = eventService.findById(id);

        return getResponse(response.getId(), request.getRequestURI());
    }

    @Override
    public ResponseEntity<CustomResponse> updateEvent(@PathVariable("id") Integer id) throws ControllerException, NotContentException {

        String status = eventService.updateEvent(id);

        return getResponse(status, request.getRequestURI());
    }
}
