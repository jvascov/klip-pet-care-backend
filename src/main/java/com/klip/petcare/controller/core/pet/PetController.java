package com.klip.petcare.controller.core.pet;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.PetRequestDTO;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.dto.response.PetResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.klip.petcare.controller.constants.ApiEndpointConstant.API_PETS;

@RequestMapping(value = API_PETS)
public interface PetController {


    @Operation(summary = "Find all pets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owners found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PetResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Owners not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(value = "")
    ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException;

    @Operation(summary = "Find a pet by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PetResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Pet not available", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(value = "pet/{id}")
    ResponseEntity<CustomResponse> findById(@PathVariable("id") Integer id) throws ServiceException, NotContentException;

    @Operation(summary = "Create a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pet created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PetResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/pet")
    ResponseEntity<CustomResponse> create(@RequestBody PetRequestDTO petDTO, BindingResult result) throws ControllerException, NotContentException, ServiceException;
}
