package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ApplicationErrors {

    AUTHENTICATION_ERROR("APP-00","You are not authorised to access this resource",HttpStatus.UNAUTHORIZED),
    BAD_REQUEST("APP-01","Something wrong with the request",HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("APP-02", "We are sorry for not being able to process your request.", HttpStatus.INTERNAL_SERVER_ERROR),
    DUMMY_ERROR("APP-03", "For testing", HttpStatus.BAD_REQUEST);

    private final String errorCode;
    private final String errorDescription;
    private final HttpStatus httpStatus;
}
