package com.dohko.example.domain.system.model.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户信息BO
 * @author luxiaohua
 * @create 2021-09-03 18:02
 */
@Data
public class UserInfoBO {

    private Long id;

    private String username;

    private String nickname;

    private Integer state;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
