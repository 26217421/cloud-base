package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.AppUser;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * 用户表(AppUser)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-08 20:56:26
 */
@Mapper
public interface AppUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AppUser> queryAllByLimit(Map<String, Object> pageable);

    /**
     * 统计总行数
     *
     * @param appUser 查询条件
     * @return 总行数
     */
    long count(AppUser appUser);

    /**
     * 新增数据
     *
     * @param appUser 实例对象
     * @return 影响行数
     */
    int insert(AppUser appUser);

    /**
     * 修改数据
     *
     * @param appUser 实例对象
     * @return 影响行数
     */
    int update(AppUser appUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

