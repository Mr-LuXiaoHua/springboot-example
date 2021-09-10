package com.dohko.example.infrastructure.common.manager;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.Serializable;

/**
 * @author luxiaohua
 * @create 2021-09-10 10:36
 */
@Component
public class SessionManager {

    public Object getFromSession(String sessionKey) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getAttribute(sessionKey, RequestAttributes.SCOPE_SESSION);
    }

    public void setToSession(String sessionKey, Serializable value) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        requestAttributes.setAttribute(sessionKey, value, RequestAttributes.SCOPE_SESSION);
    }
}
