package com.klip.petcare.controller.core;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.service.core.OwnerService;
import com.klip.petcare.service.core.OwnerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerControllerImpl implements OwnerController {
    //public static final OwnerService ownerService;

    @Override
    public ResponseEntity<CustomResponse> findAllOwners() throws ControllerException, NotContentException {

        //OwnerResponseDTO ownerResponseDTO = ownerService.findAll()

        return null;
    }
}
