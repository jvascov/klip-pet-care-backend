package com.klip.petcare.controller.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse {

    private String message;
    private String httpCode;
    private String uri;
    private String dataTime;


    private Object data;
}
