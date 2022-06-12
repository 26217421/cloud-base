package com.wbw.cloud.config;

import com.wbw.cloud.constants.LogQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wbw
 * @date 2022-6-12 17:02
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue logQueue() {
        Queue queue = new Queue(LogQueue.LOG_QUEUE);

        return queue;
    }
}
