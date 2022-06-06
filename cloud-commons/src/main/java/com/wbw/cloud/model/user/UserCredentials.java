package com.wbw.cloud.model.user;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户凭证表(UserCredentials)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class UserCredentials implements Serializable {
    @Serial
    private static final long serialVersionUID = 118941487623325804L;
    /**
     * 用户名或手机号等
     */
    private String username;
    /**
     * 账号类型（用户名、手机号）
     * @see com.wbw.cloud.constants.CredentialType
     */
    private String type;
    /**
     * 用户id
     */
    private Integer userid;

}

