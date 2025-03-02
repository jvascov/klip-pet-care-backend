package com.klip.petcare.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
public class ControllerException extends Exception {

    public ControllerException(Exception e) {
        super(e); // Llama al constructor de la superclase (Exception)
    }
}
