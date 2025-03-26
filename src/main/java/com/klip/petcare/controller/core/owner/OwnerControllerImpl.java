package com.klip.petcare.controller.core.owner;

import com.klip.petcare.controller.base.GenericController;
import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.core.owner.OwnerException;
import com.klip.petcare.service.core.owner.OwnerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OwnerControllerImpl extends GenericController implements OwnerController {


    private final OwnerService ownerService;
    private final HttpServletRequest request;

    public OwnerControllerImpl(final
                               OwnerService ownerService,final HttpServletRequest request) {
        this.ownerService = ownerService;
        this.request = request;
    }

    @GetMapping
    public ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException {

        List<OwnerResponseDTO> onwerList = ownerService.findAll();
        //log.info("URI" + request.getRequestURI());

        /*if (onwerList.isEmpty()) {
            throw new NotContentException();
        }

        CustomResponse response = CustomResponse.builder()
                .message(API_MSG_RESPONSE_CONSULTA + onwerList.size() + "]")
                .httpCode(HttpStatus.OK.value() + " - " + HttpStatus.OK.getReasonPhrase() )
                .uri("/owners")
                .data(onwerList)
                .dataTime( LocalDate.now().toString().formatted("DD/MM/YYYY HH:mm:ss"))
                .build();

        return ResponseEntity.ok(response);*/

        return getResponse(onwerList, request.getRequestURI());

    }


    public ResponseEntity<CustomResponse> create(@RequestBody OwnerRequestDTO ownerDTO, BindingResult result) throws ControllerException, NotContentException, ServiceException {

        if ((result.hasErrors())) {
            throw  new ControllerException(String.valueOf(result));
        }

        try {
            Integer id = ownerService.save(ownerDTO);
            return super.created(id, request.getRequestURI());
        }catch (OwnerException e) {
            return (ResponseEntity<CustomResponse>) super.internalError();
        }
    }


}
