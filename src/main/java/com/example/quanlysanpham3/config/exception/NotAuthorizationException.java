package com.example.quanlysanpham3.config.exception;

public class NotAuthorizationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public NotAuthorizationException() {
    }

    public NotAuthorizationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
