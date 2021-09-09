package com.dohko.example.domain.system.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册请求
 * @author luxiaohua
 * @create 2021-09-06 15:18
 */
@Data
public class RegisterReq {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "昵称不能为空")
    private String nickname;
}
