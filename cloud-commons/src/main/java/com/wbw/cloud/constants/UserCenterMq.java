package com.wbw.cloud.constants;

/**
 * rabbitmq的exchange和routing key定义
 * @author wbw
 * @since 2022-6-7 0:00
 */
public interface UserCenterMq {

    /**
     * 用户系统exchange名
     */
    String MQ_EXCHANGE_USER = "user.topic.exchange";

    /**
     * 角色删除routing key
     */
    String ROUTING_KEY_ROLE_DELETE = "role.delete";
}
