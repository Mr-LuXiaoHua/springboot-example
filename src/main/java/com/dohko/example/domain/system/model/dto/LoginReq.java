package com.dohko.example.domain.system.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author luxiaohua
 * @create 2021-09-06 16:41
 */
@Data
public class LoginReq {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "用户名不能为空")
    private String password;
}
