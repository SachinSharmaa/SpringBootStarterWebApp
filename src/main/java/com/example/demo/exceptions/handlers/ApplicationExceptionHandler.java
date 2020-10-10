package com.example.demo.exceptions.handlers;

import com.example.demo.enums.ApplicationErrors;
import com.example.demo.exceptions.custom.ApplicationException;
import com.example.demo.response.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.ServletException;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ResponseObject> handleException(ApplicationException applicationException) {
        log.error("OOPS! We encountered an error : ",applicationException);
        return getResponseEntity(applicationException.getApplicationError());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, ServletException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ResponseObject> handleException(Exception requestException) {
        log.error("OOPS! Something wrong with request : ",requestException);
        return getResponseEntity(ApplicationErrors.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseObject> handleException(Throwable throwable) {
        log.error("OOPS! We encountered an error : ",throwable);
        return getResponseEntity(ApplicationErrors.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ResponseObject> getResponseEntity(ApplicationErrors applicationError) {
        ResponseObject<?> responseObject = new ResponseObject(applicationError.getErrorCode(),applicationError.getErrorDescription());
        return new ResponseEntity<>(responseObject,applicationError.getHttpStatus());
    }
}
