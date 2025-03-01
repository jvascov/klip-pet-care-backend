package com.klip.petcare.controller.core;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.core.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.klip.petcare.controller.constants.ApiMessage.API_MSG_RESPONSE_CONSULTA;

@RestController
public class OwnerControllerImpl implements OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Override
    public ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException {

        List<OwnerResponseDTO> onwerList = ownerService.findAll();

        if (onwerList.isEmpty()) {
            throw new NotContentException();
        }

        CustomResponse response = CustomResponse.builder()
                .message(API_MSG_RESPONSE_CONSULTA)
                .httpCode(HttpStatus.OK.value() + " - " + HttpStatus.OK.getReasonPhrase() )
                .uri("/owners")
                .data(onwerList)
                .build();

        return ResponseEntity.ok(response);

    }
}
