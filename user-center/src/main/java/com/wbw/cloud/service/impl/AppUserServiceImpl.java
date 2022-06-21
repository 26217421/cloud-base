package com.wbw.cloud.service.impl;

import com.wbw.cloud.dao.AppUserDao;
import com.wbw.cloud.model.Page;
import com.wbw.cloud.model.user.AppUser;
import com.wbw.cloud.model.user.LoginAppUser;
import com.wbw.cloud.model.user.SysRole;
import com.wbw.cloud.service.AppUserService;
import com.wbw.cloud.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wbw
 * @date 2022-6-12 2:18
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    final
    AppUserDao userDao;

    public AppUserServiceImpl(AppUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 添加应用用户
     *
     * @param appUser 应用用户
     */
    @Override
    public void addAppUser(AppUser appUser) {

    }

    /**
     * 更新应用用户
     *
     * @param appUser 应用用户
     */
    @Override
    public void updateAppUser(AppUser appUser) {

    }

    /**
     * 按用户名查找
     *
     * @param username 用户名
     * @return {@link LoginAppUser}
     */
    @Override
    public LoginAppUser findByUsername(String username) {
        return null;
    }

    /**
     * 按id查找
     *
     * @param id 用户id
     * @return {@link AppUser}
     */
    @Override
    public AppUser findById(Long id) {
        return null;
    }

    /**
     * 设置角色到用户
     *
     * @param id      用户id
     * @param roleIds 角色ID
     */
    @Override
    public void setRoleToUser(Long id, Set<Long> roleIds) {

    }

    /**
     * 更新密码
     *
     * @param id          用户id
     * @param oldPassword 旧密码
     * @param newPassword 新建密码
     */
    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {

    }

    /**
     * 查找用户
     *
     * @param params 参数
     * @return {@link Page}<{@link AppUser}>
     */
    @Override
    public Page<AppUser> findUsers(Map<String, Object> params) {
        int total = 0;
        List<AppUser> userList = Collections.emptyList();
        PageUtil.pageParamConver(params, true);
        userList = userDao.queryAllByLimit(params);
        total = userList.size();
        if(total == 0) {
            userList = null;
        }
        return new Page<>(total, userList);
    }

    /**
     * 通过用户id查找角色
     *
     * @param userId 用户id
     * @return {@link Set}<{@link SysRole}>
     */
    @Override
    public Set<SysRole> findRolesByUserId(Long userId) {
        return null;
    }

    /**
     * 绑定电话
     *
     * @param userId 用户id
     * @param phone  电话
     */
    @Override
    public void bindingPhone(Long userId, String phone) {

    }
}
