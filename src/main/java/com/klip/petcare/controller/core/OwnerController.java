package com.klip.petcare.controller.core;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.klip.petcare.controller.constants.ApiEndpointConstant.API_OWNER;

@RequestMapping(value = API_OWNER)
public interface OwnerController {


    @Operation(summary = "Find all owners")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owners found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = OwnerResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Owners not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(value = "")
    ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException;

    @Operation(summary = "Find all owners")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owners found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = OwnerResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid owner", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/owner")
    ResponseEntity<CustomResponse> create(@RequestBody OwnerRequestDTO ownerDTO) throws ControllerException, NotContentException, ServiceException;
}
