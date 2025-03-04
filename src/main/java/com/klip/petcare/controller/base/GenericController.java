package com.klip.petcare.controller.base;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.ControllerException;
import com.klip.petcare.controller.exceptions.NotContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.klip.petcare.util.CollectionValid.isContent;
import static com.klip.petcare.controller.constants.ApiMessage.API_MSG_RESPONSE_CONSULTA;
import static java.util.Objects.isNull;



public abstract class GenericController {

    protected ResponseEntity<CustomResponse> getResponse(List<?> data, String uri) throws NotContentException {
        if(!isContent(data)){
            throw new NotContentException();
        }

        CustomResponse response = CustomResponse.builder()
                .message(API_MSG_RESPONSE_CONSULTA + data.size() + "]")
                .uri(uri)
                .httpCode(HttpStatus.OK.value() + "-" + HttpStatus.OK.name()).dataTime(LocalDateTime.now().toString())
                .data(data).build();

        return ResponseEntity.ok(response);
    }

    protected ControllerException getException(Exception e) {
        return new ControllerException(e);
    }

    protected ResponseEntity<?> internalError() {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<List<Map<String, String>>> getErrors(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {

                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }
        ).toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    protected ResponseEntity<?> str(String str) {
        if (isNull(str)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    /*@ExceptionHandler(ServiceException.class)
    public ResponseEntity<CustomResponse> handleServiceException(ServiceException e) {
        CustomResponse response = CustomResponse.builder()
                .message("Error en el servicio: " + e.getMessage())
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+ " - " + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }*/
}
