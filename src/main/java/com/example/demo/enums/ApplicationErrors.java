package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ApplicationErrors {

    AUTHENTICATION_ERROR("APP-00","You are not authorised to access this resource",HttpStatus.UNAUTHORIZED);

    private final String errorCode;
    private final String errorDescription;
    private final HttpStatus httpStatus;
}
