package com.klip.petcare.controller.core.daycare;

import com.klip.petcare.controller.base.GenericController;
import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.DaycareRequestDTO;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.core.daycare.DaycareService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaycareControllerImpl extends GenericController implements DaycareController {

    private final DaycareService daycareService;
    private final HttpServletRequest request;

    public DaycareControllerImpl(final DaycareService daycareService, final HttpServletRequest request) {
        this.daycareService = daycareService;
        this.request = request;
    }


    @Override
    public ResponseEntity<CustomResponse> create(DaycareRequestDTO daycareRequest, BindingResult result) throws ControllerException, ServiceException, NotContentException {

        Integer daycareId = daycareService.save(daycareRequest);

        return super.created(daycareId, request.getRequestURI());
    }

    @Override
    public ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException {

        return getResponse(daycareService.findAll(), request.getRequestURI());
    }

    @Override
    public ResponseEntity<CustomResponse> findById(@PathVariable("id") Integer id) throws ControllerException, NotContentException {
        return getResponse(daycareService.findById(id), request.getRequestURI());
    }
}
