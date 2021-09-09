package com.dohko.example.domain.system.model.dto;

import com.dohko.example.domain.system.model.bo.UserInfoBO;
import lombok.Data;

/**
 * @author luxiaohua
 * @create 2021-09-06 16:42
 */
@Data
public class LoginResp {

    private UserInfoBO userInfoBO;
}
