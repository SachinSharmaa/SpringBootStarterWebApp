package com.example.demo.response;

import com.example.demo.constants.ApplicationConstants;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;

import java.io.Serializable;

@Setter
@Getter
public class ResponseObject<T> implements Serializable {

    private static final long serialVersionUID = 2575849687763068343L;

    private String requestId;
    private String errorCode;
    private String errorDescription;
    private T resultData;

    public ResponseObject(T resultData) {
        this.resultData = resultData;
        this.requestId = MDC.get(ApplicationConstants.REQUEST_ID);
    }

    public ResponseObject(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.requestId = MDC.get(ApplicationConstants.REQUEST_ID);
    }
}
