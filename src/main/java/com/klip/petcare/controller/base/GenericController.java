package com.klip.petcare.controller.base;

import com.klip.petcare.controller.commons.CustomResponse;
import com.klip.petcare.controller.exceptions.NotContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import static com.klip.petcare.util.CollectionValid.isContent;
import static com.klip.petcare.controller.constants.ApiMessage.API_MSG_RESPONSE_CONSULTA;

public abstract class GenericController {

    protected ResponseEntity<CustomResponse> getResponse(List<?> data) throws NotContentException {
        if(!isContent(data)){
            throw new NotContentException();
        }

        CustomResponse response = CustomResponse.builder()
                .message(API_MSG_RESPONSE_CONSULTA + data.size())
                .httpCode(HttpStatus.OK.value() + "-" + HttpStatus.OK.name()).dataTime(LocalDateTime.now().toString())
                .data(data).build();

        return ResponseEntity.ok(response);
    }
}
