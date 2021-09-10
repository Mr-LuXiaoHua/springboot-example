package com.dohko.example.domain.system.manager;

import com.dohko.example.infrastructure.common.manager.SessionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户session管理
 * @author luxiaohua
 * @create 2021-09-09 16:35
 */
@Component
public class UserSessionManager {

    private static final String USER_INFO_SESSION_KEY = "SESSION_USER_INFO";

    @Resource
    private SessionManager sessionManager;

    public void setToSession(Long userId) {
        sessionManager.setToSession(USER_INFO_SESSION_KEY, userId);
    }

    public Long getFromSession() {
        Long userId = (Long) sessionManager.getFromSession(USER_INFO_SESSION_KEY);
        return userId;
    }

}
