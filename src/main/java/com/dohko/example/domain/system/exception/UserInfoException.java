package com.dohko.example.domain.system.exception;

import com.dohko.example.infrastructure.common.exception.CustomException;
import com.dohko.example.infrastructure.common.model.enums.ResultEnum;

/**
 * 用户信息异常
 * @author luxiaohua
 * @create 2021-09-06 15:29
 */
public class UserInfoException extends CustomException {

    public UserInfoException(int code, String msg) {
        super(code, msg);
    }

    public UserInfoException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
