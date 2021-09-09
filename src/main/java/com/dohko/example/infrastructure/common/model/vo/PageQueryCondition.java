package com.dohko.example.infrastructure.common.model.vo;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author luxiaohua
 * @create 2021-09-08 11:06
 */
@Data
public class PageQueryCondition {

    @Min(value = 1, message = "页码不正确")
    private long current;

    @Min(value = 1, message = "每页显示记录数不正确")
    private long size;
}
