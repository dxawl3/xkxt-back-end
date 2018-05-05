package com.df.xkxtbackend.exception;

public class BeyondMaxException extends RuntimeException {

    public BeyondMaxException(String description) {
        super(description, null, false, false);
    }
}
