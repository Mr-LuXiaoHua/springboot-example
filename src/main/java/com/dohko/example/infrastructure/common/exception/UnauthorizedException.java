package com.dohko.example.infrastructure.common.exception;


import com.dohko.example.infrastructure.common.model.enums.ResultEnum;

/**
 * @author luxiaohua
 * @create 2021-09-10 11:35
 */
public class UnauthorizedException extends CustomException {

    //自定义构造器，只保留一个，必须输入错误码及内容
    public UnauthorizedException(int code, String msg) {
        super(code, msg);
    }

    //自定义构造器，只保留一个，必须输入错误码及内容
    public UnauthorizedException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
