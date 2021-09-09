package com.dohko.example.domain.system.model.dto;

import com.dohko.example.domain.system.model.bo.UserInfoBO;
import lombok.Data;

/**
 * 注册响应
 * @author luxiaohua
 * @create 2021-09-06 15:19
 */
@Data
public class RegisterResp {

   private UserInfoBO userInfoBO;
}
