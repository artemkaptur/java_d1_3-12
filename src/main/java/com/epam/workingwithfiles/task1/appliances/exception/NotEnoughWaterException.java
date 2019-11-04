package com.epam.workingwithfiles.task1.appliances.exception;

public final class NotEnoughWaterException extends RuntimeException {

    private static final long serialVersionUID = 3533193618822689359L;

    public NotEnoughWaterException(String message) {
        super(message);
    }

    public NotEnoughWaterException(String message, Throwable cause) {
        super(message, cause);
    }

}
