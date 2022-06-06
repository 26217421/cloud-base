package com.wbw.cloud.model.user;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 微信信息表(TWechat)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class WechatUserInfo implements Serializable {
    private static final long serialVersionUID = -27584846841866752L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 微信openid
     */
    private String openid;
    /**
     * 微信unionid
     */
    private String unionid;
    /**
     * 绑定用户的id
     */
    private Integer userid;
    /**
     * 公众号标识
     */
    private String app;
    /**
     * 微信昵称
     */
    private String nickname;
    /**
     * 微信返回的性别
     */
    private String sex;
    /**
     * 微信返回的省
     */
    private String province;
    /**
     * 微信返回的城市
     */
    private String city;
    /**
     * 微信返回的国家
     */
    private String country;
    /**
     * 微信头像
     */
    private String headimgurl;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改时间
     */
    private Date updatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

}

