package com.wbw.cloud.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 微信appid和secret对象
 * @author wbw
 * @since 2022-6-6 23:30
 */
@Getter
@Setter
@ToString
public class WechatInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 3511834512371404079L;

    private String appid;
    private String secret;
}
