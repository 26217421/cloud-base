package com.wbw.cloud.model.user;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色表(SysRole)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -33440256249417940L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 角色code
     */
    private String code;
    /**
     * 角色名
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改时间
     */
    private Date updatetime;



}

