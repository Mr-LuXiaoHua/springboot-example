package com.dohko.example.domain.system.controller;

import com.dohko.example.infrastructure.common.model.vo.Result;
import com.dohko.example.domain.system.model.bo.UserInfoBO;
import com.dohko.example.domain.system.model.dto.LoginReq;
import com.dohko.example.domain.system.model.dto.LoginResp;
import com.dohko.example.domain.system.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author luxiaohua
 * @create 2021-09-06 16:41
 */
@RestController
public class LoginController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Result<LoginResp> login(@RequestBody LoginReq loginReq) {
        UserInfoBO userInfoBO = userInfoService.login(loginReq);
        LoginResp resp = new LoginResp();
        resp.setUserInfoBO(userInfoBO);
        return Result.ok(resp);
    }
}
