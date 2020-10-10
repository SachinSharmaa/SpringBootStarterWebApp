package com.example.demo.utils;

import com.example.demo.constants.ApplicationConstants;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class CommonUtils {

    private CommonUtils() {
    }

    public static void setRequestContext() {
        String requestId = MDC.get(ApplicationConstants.REQUEST_ID);
        if (StringUtils.isEmpty(requestId)) {
            requestId = UUID.randomUUID().toString();
        }
        MDC.put(ApplicationConstants.REQUEST_ID, requestId);
    }

    public static void clearRequestContext() {
        MDC.clear();
    }
}
