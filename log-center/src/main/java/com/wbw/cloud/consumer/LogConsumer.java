package com.wbw.cloud.consumer;

import com.wbw.cloud.constants.LogQueue;
import com.wbw.cloud.model.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wbw
 * @date 2022-6-12 16:56
 */
@Slf4j
@Component
@RabbitListener(queues = LogQueue.LOG_QUEUE)
public class LogConsumer {
    private static final Logger logger = LoggerFactory.getLogger(LogConsumer.class);



    /**
     * 处理消息
     *
     * @param record
     */
    @RabbitHandler
    public void logHandler(Log record) {
        try {
            log.info(String.valueOf(record));
        } catch (Exception e) {
            logger.error("保存日志失败，日志：{}，异常：{}", log, e);
        }

    }
}
