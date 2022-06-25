package com.wbw.cloud.service.impl;

import com.wbw.cloud.dao.AppUserDao;
import com.wbw.cloud.dao.SysRoleDao;
import com.wbw.cloud.dao.SysRoleUserDao;
import com.wbw.cloud.model.Page;
import com.wbw.cloud.model.user.AppUser;
import com.wbw.cloud.model.user.LoginAppUser;
import com.wbw.cloud.model.user.SysPermission;
import com.wbw.cloud.model.user.SysRole;
import com.wbw.cloud.service.AppUserService;
import com.wbw.cloud.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wbw
 * @date 2022-6-12 2:18
 */
@Slf4j
@Service
public class AppUserServiceImpl implements AppUserService {
    final
    AppUserDao userDao;

    @Autowired
    private SysRoleUserDao userRoleDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAppUser(AppUser appUser) {
        appUser.setUpdatetime(new Date());
        userDao.update(appUser);
        log.info("修改用户：{}", appUser);
    }

    /**
     * 按用户名查找
     *
     * @param username 用户名
     * @return {@link LoginAppUser}
     */
    @Override
    public LoginAppUser findByUsername(String username) {
        AppUser appUser = userCredentialsDao.findUserByUsername(username);
        if (appUser != null) {
            LoginAppUser loginAppUser = new LoginAppUser();
            BeanUtils.copyProperties(appUser, loginAppUser);

            Set<SysRole> sysRoles = userRoleDao.findRolesByUserId(appUser.getId());
            loginAppUser.setSysRoles(sysRoles);// 设置角色

            if (!CollectionUtils.isEmpty(sysRoles)) {
                Set<Long> roleIds = sysRoles.parallelStream().map(SysRole::getId).collect(Collectors.toSet());
                Set<SysPermission> sysPermissions = sysPermissionService.findByRoleIds(roleIds);
                if (!CollectionUtils.isEmpty(sysPermissions)) {
                    Set<String> permissions = sysPermissions.parallelStream().map(SysPermission::getPermission)
                            .collect(Collectors.toSet());

                    loginAppUser.setPermissions(permissions);
                }

            }

            return loginAppUser;
        }

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
        return userDao.queryById(id);
    }

    /**
     * 设置角色到用户
     *
     * @param id      用户id
     * @param roleIds 角色ID
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void setRoleToUser(Long id, Set<Long> roleIds) {
        AppUser appUser = userDao.queryById(id);
        try {
            if (appUser == null) {
                throw new IllegalArgumentException("用户不存在");
            }

            userRoleDao.deleteById(id, null);
            if (!CollectionUtils.isEmpty(roleIds)) {
                roleIds.forEach(roleId -> {
                    userRoleDao.insert(id, roleId);
                });
            }
            log.info("修改用户：{}的角色，{}", appUser.getUsername(), roleIds);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 更新密码
     *
     * @param id          用户id
     * @param oldPassword 旧密码
     * @param newPassword 新建密码
     */
    @Transactional
    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        AppUser appUser = userDao.queryById(id);
        if (StringUtils.isNoneBlank(oldPassword)) {
            if (!passwordEncoder.matches(oldPassword, appUser.getPassword())) {
                throw new IllegalArgumentException("旧密码错误");
            }
        }

        AppUser user = new AppUser();
        user.setId(id);
        user.setPassword(passwordEncoder.encode(newPassword));

        updateAppUser(user);
        log.info("修改密码：{}", user);
    }

    /**
     * 查找用户
     *
     * @param params 参数
     * @return {@link Page}<{@link AppUser}>
     */
    @Override
    public Page<AppUser> findUsers(Map<String, Object> params) {
        int total;
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
