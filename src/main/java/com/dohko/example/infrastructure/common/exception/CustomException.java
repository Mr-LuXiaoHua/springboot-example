package com.dohko.example.infrastructure.common.exception;

import com.dohko.example.infrastructure.common.model.enums.ResultEnum;

/**
 * @author luxiaohua
 * @create 2021-09-03 11:29
 */
public class CustomException extends RuntimeException {
    // 自定义错误码
    private Integer code;

    //自定义构造器，只保留一个，必须输入错误码及内容
    public CustomException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    //自定义构造器，只保留一个，必须输入错误码及内容
    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
