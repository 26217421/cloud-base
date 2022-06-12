package com.wbw.cloud.config;

import com.wbw.cloud.utils.LogMqUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志mq自动配置
 *
 * @author wbw
 * @date 2022-6-12 16:32
 */
@Configuration
public class LogMqAutoConfig {
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public LogMqAutoConfig(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * 将LogMqClient声明成Bean
     */
    @Bean
    public LogMqUtil logMqClient() {
        return new LogMqUtil(amqpTemplate);
    }
}
