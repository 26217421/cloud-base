package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 权限标识表(SysPermission)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 00:59:31
 */
@Mapper
public interface SysPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer id);


    /**
     * 通过权限查询单条数据
     * @param permission 权限
     * @return 实例对象
     */
    @Select("select * from sys_permission t where t.permission = #{permission}")
    SysPermission queryByPermission(String permission);

    /**
     * 查询指定行数据
     *
     * @param sysPermission 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(SysPermission sysPermission, @Param("pageable") Map<String, Object> pageable);

    /**
     * 统计总行数
     *
     * @param sysPermission 查询条件
     * @return 总行数
     */
    long count(SysPermission sysPermission);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

