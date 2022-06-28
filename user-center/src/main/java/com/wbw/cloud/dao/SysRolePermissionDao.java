package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.SysPermission;
import com.wbw.cloud.model.user.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Set;

/**
 * 角色权限关系表(SysRolePermission)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 00:39:00
 */
@Mapper
public interface SysRolePermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleIds 主键
     * @return 实例对象
     */
    Set<SysPermission> findPermissionsByRoleIds(@Param("roleIds") Set<Long> roleIds);

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 影响行数
     */
    int insert(SysRolePermission sysRolePermission);


    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 影响行数
     */
    int deleteById(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

}

