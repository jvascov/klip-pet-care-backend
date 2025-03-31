package com.klip.petcare.controller.core.pet;

import com.klip.petcare.controller.base.GenericController;
import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.PetRequestDTO;
import com.klip.petcare.dto.response.PetResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.core.pet.PetService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetControllerImpl extends GenericController implements PetController {


    private final PetService petService;
    private final HttpServletRequest request;


    private static final Logger LOGGER = LoggerFactory.getLogger(PetControllerImpl.class);

    public PetControllerImpl(final PetService petService, final HttpServletRequest request) {
        this.petService = petService;
        this.request = request;
    }

    @Override
    public ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException {

        List<PetResponseDTO> pets = petService.findAll();

        return getResponse(pets, request.getRequestURI());
    }

    @Override
    public ResponseEntity<CustomResponse> findById(@PathVariable("id") Integer id) throws NotContentException, ServiceException {

        return getResponse( petService.findById(id), request.getRequestURI());

    }

    @Override
    public ResponseEntity<CustomResponse> create(PetRequestDTO petDTO, BindingResult result) throws ControllerException, NotContentException, ServiceException {

        Integer petId = petService.save(petDTO).getId();
        return  super.created(petId, request.getRequestURI());
    }


}
