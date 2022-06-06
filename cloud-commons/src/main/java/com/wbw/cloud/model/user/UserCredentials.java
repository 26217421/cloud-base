package com.wbw.cloud.model.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户凭证表(UserCredentials)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class UserCredentials implements Serializable {
    private static final long serialVersionUID = 118941487623325804L;
    /**
     * 用户名或手机号等
     */
    private String username;
    /**
     * 账号类型（用户名、手机号）
     */
    private String type;
    /**
     * 用户id
     */
    private Integer userid;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

}

