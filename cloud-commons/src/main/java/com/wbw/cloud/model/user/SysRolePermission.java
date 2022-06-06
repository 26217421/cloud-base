package com.wbw.cloud.model.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限关系表(SysRolePermission)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = -57525016188296958L;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer permissionId;




}

