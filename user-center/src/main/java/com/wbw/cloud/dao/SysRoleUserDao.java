package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.SysRole;
import com.wbw.cloud.model.user.SysRoleUser;
import org.apache.ibatis.annotations.Select;
import java.util.Set;

/**
 * 角色用户关系表(SysRoleUser)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 01:13:48
 */
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
     * @param sysRoleUser 实例对象
     * @return 影响行数
     */
    int insert(SysRoleUser sysRoleUser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(Integer userid);

}

