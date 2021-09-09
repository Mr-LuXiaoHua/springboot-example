package com.dohko.example.infrastructure.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author luxiaohua
 * @create 2021-09-06 10:52
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        generateTraceId();

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









}
