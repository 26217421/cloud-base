package com.wbw.cloud.service;

import com.wbw.cloud.model.Page;
import com.wbw.cloud.model.user.AppUser;
import com.wbw.cloud.model.user.LoginAppUser;
import com.wbw.cloud.model.user.SysRole;

import java.util.Map;
import java.util.Set;

/**
 * 应用程序用户服务
 *
 * @author wbw
 * @date 2022-6-12 2:03
 */
public interface AppUserService {

    /**
     * 添加应用用户
     *
     * @param appUser 应用用户
     */
    void addAppUser(AppUser appUser);

    /**
     * 更新应用用户
     *
     * @param appUser 应用用户
     */
    void updateAppUser(AppUser appUser);

    /**
     * 按用户名查找
     *
     * @param username 用户名
     * @return {@link LoginAppUser}
     */
    LoginAppUser findByUsername(String username);

    /**
     * 按id查找
     *
     * @param id 用户id
     * @return {@link AppUser}
     */
    AppUser findById(Long id);

    /**
     * 设置角色到用户
     *
     * @param id      用户id
     * @param roleIds 角色ID
     */
    void setRoleToUser(Long id, Set<Long> roleIds);

    /**
     * 更新密码
     *
     * @param id          用户id
     * @param oldPassword 旧密码
     * @param newPassword 新建密码
     */
    void updatePassword(Long id, String oldPassword, String newPassword);

    /**
     * 查找用户
     *
     * @param params 参数
     * @return {@link Page}<{@link AppUser}>
     */
    Page<AppUser> findUsers(Map<String, Object> params);

    /**
     * 通过用户id查找角色
     *
     * @param userId 用户id
     * @return {@link Set}<{@link SysRole}>
     */
    Set<SysRole> findRolesByUserId(Long userId);

    /**
     * 绑定电话
     *
     * @param userId 用户id
     * @param phone  电话
     */
    void bindingPhone(Long userId, String phone);
}
