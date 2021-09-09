package com.dohko.example.domain.system.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dohko.example.domain.system.model.constant.UserInfoStateConst;
import com.dohko.example.infrastructure.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author luxiaohua
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user_info")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 状态：0-冻结；1-正常
     * @see UserInfoStateConst
     */
    private Integer state;

    /**
     * 昵称
     */
    private String nickname;


}
