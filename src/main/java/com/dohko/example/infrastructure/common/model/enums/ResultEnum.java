package com.dohko.example.infrastructure.common.model.enums;

/**
 * @author luxiaohua
 * @create 2021-09-02 17:53
 */
public enum ResultEnum {

    SUCCESS(0, "success"),

    SERVER_ERROR(5000, "系统错误"),
    PARAM_ERROR(4000, "请求参数错误"),
    REQUEST_BODY_IS_MISSING(4001, "请求体缺失"),
    DATA_IS_EXIST(4002, "数据已存在"),
    DATA_NOT_EXIST(4003, "数据不存在"),


    UNKNOWN_ERROR(9999, "未知错误")
    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
