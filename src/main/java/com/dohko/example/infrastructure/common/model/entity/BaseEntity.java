package com.dohko.example.infrastructure.common.model.entity;

import com.dohko.example.infrastructure.common.model.constant.WhetherConst;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author luxiaohua
 * @create 2021-09-03 16:57
 */
@Data
public class BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已删除：0-否；1-是
     * @see WhetherConst
     */
    private Integer isDeleted;
}
