package com.klip.petcare.service.core.pet;

import com.klip.petcare.service.base.ServiceException;

import java.io.Serial;

public class PetException extends ServiceException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PetException(){}

    public PetException(String message) {
        super(message);
    }

    public PetException(Throwable cause) {
        super(cause);
    }

    public PetException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
