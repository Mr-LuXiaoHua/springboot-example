package com.dohko.example.domain.system.model.dto;

import com.dohko.example.infrastructure.common.model.vo.PageQueryCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户信息分页查询请求
 * @author luxiaohua
 * @create 2021-09-08 14:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserInfoPageQueryReq extends PageQueryCondition {

}
