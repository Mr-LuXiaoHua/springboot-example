package com.dohko.example.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author luxiaohua
 * @create 2021-09-09 16:31
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class HttpSessionConfig {

    @Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
