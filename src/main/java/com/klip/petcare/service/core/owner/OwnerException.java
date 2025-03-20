package com.klip.petcare.service.core.owner;

import com.klip.petcare.service.base.ServiceException;

import java.io.Serial;

public class OwnerException extends ServiceException {

    @Serial
    private static final long serialVersionUID = 1L;

    public OwnerException(){}

    public OwnerException(String message) {
        super(message);
    }

    public OwnerException(Throwable cause) {
        super(cause);
    }

    public OwnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
