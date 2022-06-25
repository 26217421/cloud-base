package com.wbw.cloud.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(AppUser)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
    private static final long serialVersionUID = 782550012519159874L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像url
     */
    private String headimgurl;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 状态（1有效,0无效）
     */
    private Boolean enabled;
    /**
     * 类型（暂未用）
     */
    private String type;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改时间
     */
    private Date updatetime;


}

