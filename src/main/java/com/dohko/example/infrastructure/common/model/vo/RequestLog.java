package com.dohko.example.infrastructure.common.model.vo;

import lombok.Data;

/**
 * @author luxiaohua
 * @create 2021-09-08 09:58
 */
@Data
public class RequestLog {

    private String url;
    private String httpMethod;
    private String ip;
    private String classMethod;
    private String requestParam;
}
