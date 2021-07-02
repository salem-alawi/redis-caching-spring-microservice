package com.salemalawi.coursemanagementservice.exception;

public class ResourceNotFoundCustom extends Exception  {

    public ResourceNotFoundCustom() {
    }

    public ResourceNotFoundCustom(String message) {
        super(message);
    }

    public ResourceNotFoundCustom(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundCustom(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundCustom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
