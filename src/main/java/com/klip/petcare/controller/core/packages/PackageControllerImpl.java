package com.klip.petcare.controller.core.packages;

import com.klip.petcare.controller.base.GenericController;
import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.response.PackageResponseDTO;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.core.packages.PackageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PackageControllerImpl extends GenericController implements PackageController {

    private final PackageService packageService;
    private final HttpServletRequest request;

    @Override
    public ResponseEntity<CustomResponse> findAll() throws ControllerException, NotContentException, ServiceException {
        List<PackageResponseDTO> packages = packageService.findAll();
        return getResponse(packages, request.getRequestURI());
    }

    @Override
    public ResponseEntity<CustomResponse> findById(Integer id) throws NotContentException, ServiceException {
        return getResponse(packageService.findById(id), request.getRequestURI());
    }

}
