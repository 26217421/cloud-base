package com.wbw.cloud.model.user;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 权限标识表(SysPermission)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class SysPermission implements Serializable {
    @Serial
    private static final long serialVersionUID = -18381882099366869L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 权限标识
     */
    private String permission;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;



}

