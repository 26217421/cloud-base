package com.wbw.cloud.constants;

/**
 * 邮件状态
 * @author wbw
 * @since 2022-6-6 23:26
 */
public interface MailStatus {
    /**
     * 草稿
     */
    int DRAFT = 0;
    /**
     * 发送成功
     */
    int SUCCESS = 1;
    /**
     * 发送失败
     */
    int ERROR = 2;
}
