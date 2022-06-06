package com.wbw.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author wbw
 * @since 2022-6-5 16:12
 */
@RefreshScope
@Setter
@Getter
@Configuration
public class DataConfig {
    @Value("${user}")
    private String username;
    @Value("${server.port}")
    private String port;
}
