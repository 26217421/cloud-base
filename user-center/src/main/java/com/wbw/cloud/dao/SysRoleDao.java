package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

/**
 * 角色表(SysRole)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 01:05:49
 */
@Mapper
public interface SysRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRole queryById(Integer id);

    /**
     * 通过code查询单条数据
     * @param code 代码
     * @return 实例对象
     */
    @Select("select * from sys_role t where t.code = #{code}")
    SysRole queryByCode(String code);
    /**
     * 查询指定行数据
     *
     * @param sysRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(SysRole sysRole, @Param("pageable") Map<String, Object> pageable);

    /**
     * 统计总行数
     *
     * @param sysRole 查询条件
     * @return 总行数
     */
    long count(SysRole sysRole);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

