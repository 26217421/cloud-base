package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.WechatUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * 微信信息表(Wechat)表数据库访问层
 *
 * @author wbw
 * @since 2022-06-09 01:18:08
 */
@Mapper
public interface WechatDao {

    /**
     * 通过微信openid查询单条数据
     * @param openid 微信openid
     * @return
     */
    @Select("select * from t_wechat t where t.openid = #{openid}")
    WechatUserInfo findByOpenid(String openid);

    /**
     * 通过微信unionid查询单条数据
     * @param unionid 微信unionid
     * @return
     */
    @Select("select * from t_wechat t where t.unionid = #{unionid}")
    Set<WechatUserInfo> findByUnionId(String unionid);


    /**
     * 新增数据
     *
     * @param wechat 实例对象
     * @return 影响行数
     */
    int insert(WechatUserInfo wechat);


    /**
     * 修改数据
     *
     * @param wechat 实例对象
     * @return 影响行数
     */
    int update(WechatUserInfo wechat);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

