package com.wbw.cloud.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 微信网页授权access_token信息
 * @author wbw
 * @since 2022-6-6 23:31
 */
@Getter
@Setter
@ToString
public class WechatAccess implements Serializable {
    @Serial
    private static final long serialVersionUID = 6571363417369764704L;

    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private String openid;
    private String scope;
}
