package com.dohko.example.domain.system.service;

import com.dohko.example.infrastructure.common.model.vo.PageVO;
import com.dohko.example.domain.system.model.bo.UserInfoBO;
import com.dohko.example.domain.system.model.dto.LoginReq;
import com.dohko.example.domain.system.model.dto.RegisterReq;
import com.dohko.example.domain.system.model.dto.UserInfoPageQueryReq;

/**
 * @author luxiaohua
 * @create 2021-09-03 17:11
 */
public interface UserInfoService {

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    UserInfoBO getById(Long id);

    /**
     * 注册
     * @param registerReq
     * @return
     */
    UserInfoBO register(RegisterReq registerReq);

    /**
     * 登录
     * @param loginReq
     * @return
     */
    UserInfoBO login(LoginReq loginReq);


    PageVO<UserInfoBO> pageQuery(UserInfoPageQueryReq userInfoPageQueryReq);
}
