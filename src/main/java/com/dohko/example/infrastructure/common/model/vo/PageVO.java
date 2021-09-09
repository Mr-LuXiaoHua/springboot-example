package com.dohko.example.infrastructure.common.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author luxiaohua
 * @create 2021-09-08 11:01
 */
@Data
public class PageVO<T> {

    /**
     * 当前页
     */
    private long current;

    /**
     * 每页显示
     */
    private long size;

    /**
     * 总记录
     */
    private long total;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 记录数
     */
    private List<T> recordList;

}
