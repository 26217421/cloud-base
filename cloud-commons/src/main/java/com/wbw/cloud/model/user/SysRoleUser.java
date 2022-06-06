package com.wbw.cloud.model.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色用户关系表(SysRoleUser)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class SysRoleUser implements Serializable {
    private static final long serialVersionUID = -43278995395469571L;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 角色id
     */
    private Integer roleid;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}

