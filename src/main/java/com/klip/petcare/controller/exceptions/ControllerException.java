package com.klip.petcare.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor

public class ControllerException extends Exception {

    public ControllerException() {
        // TODO Auto-generated constructor stub
    }

    public ControllerException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ControllerException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }
}
