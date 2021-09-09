package com.dohko.example.domain.system.controller;

import com.dohko.example.infrastructure.common.model.vo.Result;
import com.dohko.example.domain.system.model.bo.UserInfoBO;
import com.dohko.example.domain.system.model.dto.RegisterReq;
import com.dohko.example.domain.system.model.dto.RegisterResp;
import com.dohko.example.domain.system.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author luxiaohua
 * @create 2021-09-06 15:17
 */
@RestController
public class RegisterController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public Result<RegisterResp> register(@RequestBody RegisterReq registerReq) {

        UserInfoBO userInfoBO = userInfoService.register(registerReq);
        RegisterResp resp = new RegisterResp();
        resp.setUserInfoBO(userInfoBO);
        return Result.ok(resp);
    }

}
