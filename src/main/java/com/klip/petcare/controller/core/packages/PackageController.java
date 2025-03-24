package com.klip.petcare.controller.core.packages;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.response.PackageResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.klip.petcare.controller.constants.ApiEndpointConstant.API_PACKAGE;

@RequestMapping(value = API_PACKAGE)
public interface PackageController {

    @Operation(summary = "Find all packages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Packages found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PackageResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Packages not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping()
    ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException;

    @Operation(summary = "Find a package by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PackageResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Package not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("package/{id}")
    ResponseEntity<CustomResponse> findById(@PathVariable("id") Integer id) throws ServiceException, NotContentException;

}
