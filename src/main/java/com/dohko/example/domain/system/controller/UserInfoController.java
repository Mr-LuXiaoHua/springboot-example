package com.dohko.example.domain.system.controller;

import com.dohko.example.infrastructure.common.model.vo.PageVO;
import com.dohko.example.infrastructure.common.model.vo.Result;
import com.dohko.example.domain.system.model.bo.UserInfoBO;
import com.dohko.example.domain.system.model.dto.UserInfoPageQueryReq;
import com.dohko.example.domain.system.model.dto.UserInfoPageQueryResp;
import com.dohko.example.domain.system.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author luxiaohua
 * @create 2021-09-08 10:58
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/page-query")
    public Result<UserInfoPageQueryResp> pageQuery(@RequestBody @Valid UserInfoPageQueryReq userInfoPageQueryReq) {
        PageVO<UserInfoBO> pageVO = userInfoService.pageQuery(userInfoPageQueryReq);
        UserInfoPageQueryResp resp = new UserInfoPageQueryResp();
        resp.setPageVO(pageVO);

        return Result.ok(resp);
    }
}
