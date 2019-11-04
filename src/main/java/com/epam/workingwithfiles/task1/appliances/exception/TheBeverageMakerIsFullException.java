package com.epam.workingwithfiles.task1.appliances.exception;

public class TheBeverageMakerIsFullException extends RuntimeException {

    private static final long serialVersionUID = -1540489274292127128L;

    public TheBeverageMakerIsFullException(String message) {
        super(message);
    }

    public TheBeverageMakerIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

}
