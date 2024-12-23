package com.elearning.exceptions;

import lombok.Getter;

@Getter
public class CodalCustomException extends RuntimeException {

    private final ErrorCode errorCode;

    public CodalCustomException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CodalCustomException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public enum ErrorCode {
        USERNAME_ALREADY_EXISTS,
        ROLE_NOT_FOUND,
        COUNTRY_NOT_FOUND,
        INVALID_INPUT,
        INTERNAL_ERROR
    }

    public static CodalCustomException usernameAlreadyExists(String message) {
        return new CodalCustomException(message, ErrorCode.USERNAME_ALREADY_EXISTS);
    }

    public static CodalCustomException roleNotFound(String message) {
        return new CodalCustomException(message, ErrorCode.ROLE_NOT_FOUND);
    }

    public static CodalCustomException countryNotFound(String message) {
        return new CodalCustomException(message, ErrorCode.COUNTRY_NOT_FOUND);
    }

    public static CodalCustomException invalidInput(String message) {
        return new CodalCustomException(message, ErrorCode.INVALID_INPUT);
    }

    public static CodalCustomException internalError(String message, Throwable cause) {
        return new CodalCustomException(message, cause, ErrorCode.INTERNAL_ERROR);
    }
}

