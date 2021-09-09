package com.dohko.example.domain.system.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dohko.example.domain.system.repository.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author luxiaohua
 * @since 2021-09-02
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Map selectByUsername(String username);

}
