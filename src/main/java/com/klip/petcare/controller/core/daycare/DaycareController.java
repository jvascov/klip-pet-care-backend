package com.klip.petcare.controller.core.daycare;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.DaycareRequestDTO;
import com.klip.petcare.dto.response.PetResponseDTO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static  com.klip.petcare.controller.constants.ApiEndpointConstant.API_DAYCARE;

@RequestMapping(value = API_DAYCARE)
public interface DaycareController {

    @Operation(summary = "Create Daycare")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Daycare created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PetResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping()
    ResponseEntity<CustomResponse> create(@Valid @RequestBody DaycareRequestDTO daycareRequest, BindingResult result) throws ControllerException, ServiceException, NotContentException;

    @Operation(summary = "Find all daycare")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Daycare found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PetResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Daycare are not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(value = "")
    ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException;

    @Operation(summary = "Find a daycare by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Daycare found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PetResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Daycare not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(value = "daycare/{id}")
    ResponseEntity<CustomResponse> findById(Integer id) throws ControllerException, NotContentException;
}
