package com.dohko.example.infrastructure.common.aop;

import com.dohko.example.infrastructure.common.model.constant.SymbolConst;
import com.dohko.example.infrastructure.common.model.vo.RequestLog;
import com.dohko.example.infrastructure.utils.JsonUtils;
import com.dohko.example.infrastructure.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author luxiaohua
 * @create 2021-09-07 17:28
 */

@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut("execution(public * com.feishu.*.domain.*.controller..*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        RequestLog requestLog = assembleRequestLog(pjp);
        log.info("###请求报文: {}", JsonUtils.toJsonString(requestLog));

        long beginTime = System.currentTimeMillis();
        Object result = pjp.proceed();

        log.info("###处理耗时: {} ms", System.currentTimeMillis() - beginTime);

        return result;
    }


    /**
     * 组装请求日志
     * @param pjp
     * @return
     */
    private RequestLog assembleRequestLog(ProceedingJoinPoint pjp) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        String url = request.getRequestURL().toString();
        String ip = RequestUtils.getIp(request);
        String httpMethod = request.getMethod();
        String classMethod = pjp.getSignature().getDeclaringTypeName() + SymbolConst.DOT + pjp.getSignature().getName();

        RequestLog requestLog = new RequestLog();
        requestLog.setClassMethod(classMethod);
        requestLog.setHttpMethod(httpMethod);
        requestLog.setIp(ip);
        requestLog.setUrl(url);
        requestLog.setRequestParam(Arrays.toString(pjp.getArgs()));

        return requestLog;

    }

}
