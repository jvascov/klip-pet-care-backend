package com.klip.petcare.controller.core.daycare.event;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.EventRequestDTO;
import com.klip.petcare.dto.request.EventRequestUpdateDTO;
import com.klip.petcare.dto.response.EventResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.klip.petcare.controller.constants.ApiEndpointConstant.API_EVENT;

@RequestMapping(value = API_EVENT)
public interface EventController {


    @Operation(summary = "Create Event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = EventResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping()
    ResponseEntity<CustomResponse> save(@Valid @RequestBody EventRequestDTO eventRequest, BindingResult result) throws ControllerException, ServiceException, NotContentException;

    @Operation(summary = "Find a event by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = EventResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Event not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(value = "{id}")
    ResponseEntity<CustomResponse> findById(Integer id) throws ControllerException, NotContentException;


    @Operation(summary = "Update an event by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = EventResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Event not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PutMapping(value = "{id}")
    ResponseEntity<CustomResponse> updateEvent(@Valid @PathVariable("id") Integer id) throws ControllerException, NotContentException;
}
