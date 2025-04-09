package com.altir.onboarding.exception;

public class OrganizationAlreadyExistsException extends RuntimeException {
    public OrganizationAlreadyExistsException(String message) {
        super(message);
    }
}
