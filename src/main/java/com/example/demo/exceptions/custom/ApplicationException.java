package com.example.demo.exceptions.custom;

import com.example.demo.enums.ApplicationErrors;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException{

    private final ApplicationErrors applicationError;

    public ApplicationException(ApplicationErrors applicationError) {
        this.applicationError = applicationError;
    }

    public ApplicationException(ApplicationErrors applicationError, Throwable throwable) {
        super(throwable);
        this.applicationError = applicationError;
    }
}
