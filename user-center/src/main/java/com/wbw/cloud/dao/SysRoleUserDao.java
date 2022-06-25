package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Set;

/**
 * 角色用户关系表(SysRoleUser)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 01:13:48
 */
@Mapper
public interface SysRoleUserDao {

    /**
     * 根据用户id获取角色
     * @param userId 主键
     * @return SysRole实例对象
     */
    @Select("select r.* from sys_role_user ru inner join sys_role r on r.id = ru.roleId where ru.userId = #{userId}")
    Set<SysRole> findRolesByUserId(Long userId);

    /**
     * 新增数据
     *
     *
     * @param userId
     * @param roleId
     * @return 影响行数
     */
    int insert(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(@Param("userId") Long userid, @Param("roleId") Long roleId);

}

