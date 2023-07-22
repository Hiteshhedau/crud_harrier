package com.crud.error;

public class InvalidCustomerCreatedException extends Exception {
   

    public InvalidCustomerCreatedException() {
        super();
    }

    public InvalidCustomerCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCustomerCreatedException(Throwable cause) {
        super(cause);
    }

    protected InvalidCustomerCreatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidCustomerCreatedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
