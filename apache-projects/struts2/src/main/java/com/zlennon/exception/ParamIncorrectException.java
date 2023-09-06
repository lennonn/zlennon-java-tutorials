package com.zlennon.exception;

public class ParamIncorrectException extends Exception {

    private int statusCode;

    public ParamIncorrectException(String message) {
        super(message);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
