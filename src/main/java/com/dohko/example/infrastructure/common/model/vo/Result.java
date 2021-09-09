package com.dohko.example.infrastructure.common.model.vo;

import com.dohko.example.infrastructure.common.model.enums.ResultEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Objects;


/**
 * @author luxiaohua
 * @create 2021-09-02 17:51
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    private Result(){}

    public static <T> Result<T> ok() {
        return ok(ResultEnum.SUCCESS);
    }

    public static <T> Result<T> ok(T data) {
        return result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error(String message) {
        return result(ResultEnum.SERVER_ERROR.getCode(), message, null);
    }

    public static <T> Result<T> error(ResultEnum resultEnum) {
        return result(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return result(code, message, null);
    }

    public static <T> Result<T> ok(ResultEnum resultEnum) {
        return result(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    private static <T> Result<T> result(Integer code, String message, T data) {
        Result r = new Result();
        r.setCode(code);
        r.setMessage(message);
        if (Objects.nonNull(data)) {
            r.setData(data);
        } else {
            r.setData(new HashMap<>());
        }
        return r;
    }



}
