package com.wbw.cloud.model.user;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 权限标识表(SysPermission)实体类
 *
 * @author wbw
 * @since 2022-06-06 19:45:01
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -18381882099366869L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 权限标识
     */
    private String permission;
    /**
     * 名称
     */
    private String name;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

