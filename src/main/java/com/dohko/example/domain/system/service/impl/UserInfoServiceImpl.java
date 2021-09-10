package com.dohko.example.domain.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dohko.example.domain.system.manager.UserSessionManager;
import com.dohko.example.domain.system.repository.entity.UserInfo;
import com.dohko.example.domain.system.repository.mapper.UserInfoMapper;
import com.dohko.example.infrastructure.common.model.constant.WhetherConst;
import com.dohko.example.infrastructure.common.model.enums.ResultEnum;
import com.dohko.example.infrastructure.common.model.vo.PageVO;
import com.dohko.example.infrastructure.utils.BeanTools;
import com.dohko.example.infrastructure.utils.EncryptionUtils;
import com.dohko.example.infrastructure.utils.PageUtils;
import com.dohko.example.infrastructure.utils.StrUtils;
import com.dohko.example.domain.system.exception.UserInfoException;
import com.dohko.example.domain.system.model.bo.UserInfoBO;
import com.dohko.example.domain.system.model.constant.UserInfoStateConst;
import com.dohko.example.domain.system.model.dto.LoginReq;
import com.dohko.example.domain.system.model.dto.RegisterReq;
import com.dohko.example.domain.system.model.dto.UserInfoPageQueryReq;
import com.dohko.example.domain.system.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author luxiaohua
 * @create 2021-09-03 17:11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserSessionManager userSessionManager;

    @Override
    public UserInfoBO getById(Long id) {
        UserInfo userInfo = userInfoMapper.selectById(id);
        UserInfoBO userInfoBO = BeanTools.copy(userInfo, UserInfoBO.class);
        return userInfoBO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoBO register(RegisterReq registerReq) {

        decideUserInfoIsExist(registerReq.getUsername());

        UserInfo userInfo = assembleUserInfo(registerReq);
        String salt = generatorSalt();
        String realPassword = generatorPassword(registerReq.getPassword(), salt);

        userInfo.setSalt(salt);
        userInfo.setPassword(realPassword);

        userInfoMapper.insert(userInfo);

        UserInfoBO userInfoBO = BeanTools.copy(userInfo, UserInfoBO.class);
        return userInfoBO;

    }

    @Override
    public UserInfoBO login(LoginReq loginReq) {

        UserInfo userInfo = getByUsername(loginReq.getUsername());
        if (Objects.isNull(userInfo)) {
            throw new UserInfoException(ResultEnum.DATA_NOT_EXIST.getCode(), "用户名或密码错误");
        }

        checkPassword(loginReq.getPassword(), userInfo.getPassword(), userInfo.getSalt());
        UserInfoBO userInfoBO = BeanTools.copy(userInfo, UserInfoBO.class);
        storeToSession(userInfoBO);

        return userInfoBO;

    }

    @Override
    public PageVO<UserInfoBO> pageQuery(UserInfoPageQueryReq userInfoPageQueryReq) {

        Page<UserInfo> page = new Page<>(userInfoPageQueryReq.getCurrent(), userInfoPageQueryReq.getSize());
        userInfoMapper.selectPage(page, null);

        PageVO<UserInfoBO> pageVO = PageUtils.toPageVO(page, UserInfoBO.class);

        return pageVO;
    }




    /**
     * 判断用户是否已存在
     * @param username
     */
    private void decideUserInfoIsExist(String username) {
        UserInfo userInfo = getByUsername(username);
        if (Objects.nonNull(userInfo)) {
            throw new UserInfoException(ResultEnum.DATA_IS_EXIST.getCode(), "用户已存在");
        }
    }


    /**
     * 生成盐值
     * @return
     */
    private String generatorSalt() {
        return StrUtils.randomStr(6);
    }

    /**
     * 生成密码
     * @param password
     * @param salt
     * @return
     */
    private String generatorPassword(String password, String salt) {
        String realPassword = password + salt;
        return EncryptionUtils.sha256Hex(realPassword);
    }


    /**
     * 组装UserInfo
     * @param registerReq
     * @return
     */
    private UserInfo assembleUserInfo(RegisterReq registerReq) {
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname(registerReq.getNickname());
        userInfo.setUsername(registerReq.getUsername());
        userInfo.setState(UserInfoStateConst.NORMAL);
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setUpdateTime(LocalDateTime.now());
        userInfo.setIsDeleted(WhetherConst.NO);
        return userInfo;
    }


    public UserInfo getByUsername(String username) {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserInfo::getUsername, username);
        UserInfo userInfo = userInfoMapper.selectOne(lambdaQueryWrapper);
        return userInfo;
    }


    private void checkPassword(String inputPassword, String realPassword, String salt) {
        String password = generatorPassword(inputPassword, salt);
        if (!password.equals(realPassword)) {
            throw new UserInfoException(ResultEnum.DATA_NOT_EXIST.getCode(), "用户名或密码错误");
        }
    }


    /**
     * 存储到session
     * @param userInfoBO
     */
    private void storeToSession(UserInfoBO userInfoBO) {
        userSessionManager.setToSession(userInfoBO.getId());
    }




}
