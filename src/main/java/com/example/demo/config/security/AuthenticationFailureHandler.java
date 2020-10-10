package com.example.demo.config.security;

import com.example.demo.enums.ApplicationErrors;
import com.example.demo.response.ResponseObject;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.ConversionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Slf4j
public class AuthenticationFailureHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        CommonUtils.setRequestContext();
        log.error("OOPS Authentication Error!", e);
        ApplicationErrors authenticationError = ApplicationErrors.AUTHENTICATION_ERROR;
        ResponseObject<?> responseObject = new ResponseObject(authenticationError.getErrorCode(), authenticationError.getErrorDescription());

        httpServletResponse.setStatus(authenticationError.getHttpStatus().value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().append(ConversionUtil.toJsonString(responseObject));
    }
}
