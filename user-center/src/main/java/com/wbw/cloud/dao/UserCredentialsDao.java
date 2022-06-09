package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.AppUser;
import com.wbw.cloud.model.user.UserCredentials;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户凭证表(UserCredentials)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 01:09:55
 */
@Mapper
public interface UserCredentialsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    UserCredentials queryById(String username);

    /**
     * 通过username查询AppUser
     * @param username 主键
     * @return AppUser实例对象
     */
    @Select("select u.* from app_user u inner join user_credentials c on c.userId = u.id where c.username = #{username}")
    AppUser findUserByUsername(String username);

    /**
     * 新增数据
     *
     * @param userCredentials 实例对象
     * @return 影响行数
     */
    int insert(UserCredentials userCredentials);

}

