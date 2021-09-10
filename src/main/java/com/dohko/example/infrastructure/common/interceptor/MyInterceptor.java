package com.dohko.example.infrastructure.common.interceptor;

import com.dohko.example.domain.system.manager.UserSessionManager;
import com.dohko.example.infrastructure.common.exception.UnauthorizedException;
import com.dohko.example.infrastructure.common.model.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Objects;
import java.util.UUID;

/**
 * @author luxiaohua
 * @create 2021-09-06 10:52
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    private static final String TRACE_ID = "TRACE_ID";

    @Resource
    private UserSessionManager userSessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String h = headerNames.nextElement();
            String v = request.getHeader(h);
            log.info("header:{}, value:{}", h, v);
        }

        generateTraceId();
        isUserLogin();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        removeTraceId();
    }


    /**
     * 生成traceId
     */
    private void generateTraceId() {
        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID, traceId);
    }

    /**
     * 删除traceId
     */
    private void removeTraceId() {
        MDC.remove(TRACE_ID);
    }


    /**
     * 用户是否已登录
     */
    private void isUserLogin() {
        Long userId = userSessionManager.getFromSession();
        if (Objects.isNull(userId)) {
            throw new UnauthorizedException(ResultEnum.UNAUTHORIZED);
        }
    }






}
