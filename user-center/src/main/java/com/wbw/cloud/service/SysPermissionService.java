package com.wbw.cloud.service;

import com.wbw.cloud.model.Page;
import com.wbw.cloud.model.user.SysPermission;

import java.util.Map;
import java.util.Set;

/**
 * sys权限服务
 *
 * @author wbw
 * @date 2022-6-26 12:08
 */
public interface SysPermissionService {

    /**
     * 通过角色id查找权限集合
     *
     * @param roleIds 角色ID
     * @return {@link Set}<{@link SysPermission}>
     */
    Set<SysPermission> findByRoleIds(Set<Long> roleIds);

    /**
     * 添加权限
     *
     * @param sysPermission sys权限
     */
    void save(SysPermission sysPermission);

    /**
     * 更新权限
     *
     * @param sysPermission sys权限
     */
    void update(SysPermission sysPermission);

    /**
     * 删去权限
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 查找权限
     *
     * @param params 参数
     * @return {@link Page}<{@link SysPermission}>
     */
    Page<SysPermission> findPermissions(Map<String, Object> params);
}
