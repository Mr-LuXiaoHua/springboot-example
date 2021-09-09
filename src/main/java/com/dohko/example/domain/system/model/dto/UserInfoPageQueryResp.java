package com.dohko.example.domain.system.model.dto;

import com.dohko.example.infrastructure.common.model.vo.PageVO;
import com.dohko.example.domain.system.model.bo.UserInfoBO;
import lombok.Data;

/**
 * 用户信息分页查询响应
 * @author luxiaohua
 * @create 2021-09-08 14:12
 */
@Data
public class UserInfoPageQueryResp {

    private PageVO<UserInfoBO> pageVO;
}
