package com.dohko.example.infrastructure.common.handler;

import com.dohko.example.infrastructure.common.exception.CustomException;
import com.dohko.example.infrastructure.common.model.enums.ResultEnum;
import com.dohko.example.infrastructure.common.model.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理器
 * @author luxiaohua
 * @create 2021-09-03 10:50
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    /**
     * 参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result customExceptionHandler(MethodArgumentNotValidException e){

        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors() && CollectionUtils.isNotEmpty(bindingResult.getAllErrors())) {
            FieldError fieldError = (FieldError) bindingResult.getAllErrors().get(0);
            return Result.error(ResultEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
        }

        return Result.error(ResultEnum.PARAM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 缺失请求体
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result customExceptionHandler(HttpMessageNotReadableException e){
        log.error(e.getMessage(), e);
        return Result.error(ResultEnum.REQUEST_BODY_IS_MISSING);
    }

    @ExceptionHandler(value = CustomException.class)
    public Result customExceptionHandler(CustomException e){
        log.error("错误信息-> code:{}, message:{}", e.getCode(), e.getMessage());
        return Result.error(e.getCode(), e.getMessage());
    }




}
