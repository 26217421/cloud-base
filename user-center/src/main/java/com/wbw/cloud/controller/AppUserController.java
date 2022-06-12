package com.wbw.cloud.controller;

import com.wbw.cloud.model.Page;
import com.wbw.cloud.model.user.AppUser;
import com.wbw.cloud.model.user.LoginAppUser;
import com.wbw.cloud.model.user.SysRole;
import com.wbw.cloud.service.AppUserService;
import com.wbw.cloud.utils.AppUserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/**
 * 应用程序用户控制器
 *
 * @author wbw
 * @date 2022-6-12 1:56
 */
@RestController
public class AppUserController {
    AppUserService userService;


    @GetMapping("/users/current")
    public LoginAppUser getLoginAppUser() {
        return null;
        //return AppUserUtil.getLoginAppUser();
    }

    @GetMapping(value = "/users-anon/internal", params = "username")
    public LoginAppUser findByUsername(String username) {
        //return userService.findByUsername(username);
        return null;
    }

    /**
     * 查找用户
     * 用户查询
     *
     * @param params 参数
     * @return {@link Page}<{@link AppUser}>
     */
    @GetMapping("/users")
    public Page<AppUser> findUsers(@RequestParam Map<String, Object> params) {
        return userService.findUsers(params);
    }

    /**
     * 查找用户通过id
     *
     * @param id 用户id
     * @return {@link AppUser}
     */
    @GetMapping("/users/{id}")
    public AppUser findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * 添加用户,根据用户名注册
     *
     * @param appUser
     */
    @PostMapping("/users-anon/register")
    public AppUser register(@RequestBody AppUser appUser) {
        // 用户名等信息的判断逻辑挪到service了
        userService.addAppUser(appUser);

        return appUser;
    }

    /**
     * 修改自己的个人信息
     *
     * @param appUser 应用用户
     * @return {@link AppUser}
     */
    @PutMapping("/users/me")
    public AppUser updateMe(@RequestBody AppUser appUser) {


        return appUser;
    }

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    @PutMapping(value = "/users/password", params = {"oldPassword", "newPassword"})
    public void updatePassword(String oldPassword, String newPassword) {
        if (StringUtils.isBlank(oldPassword)) {
            throw new IllegalArgumentException("旧密码不能为空");
        }
        if (StringUtils.isBlank(newPassword)) {
            throw new IllegalArgumentException("新密码不能为空");
        }

/*        AppUser user = AppUserUtil.getLoginAppUser();
        userService.updatePassword(user.getId(), oldPassword, newPassword);*/
    }

    /**
     * 管理后台，给用户重置密码
     *
     * @param id          用户id
     * @param newPassword 新密码
     */
    @PreAuthorize("hasAuthority('back:user:password')")
    @PutMapping(value = "/users/{id}/password", params = {"newPassword"})
    public void resetPassword(@PathVariable Long id, String newPassword) {
        userService.updatePassword(id, null, newPassword);
    }

    /**
     * 管理后台修改用户
     *
     * @param appUser 应用用户
     */
    @PutMapping("/users")
    public void updateAppUser(@RequestBody AppUser appUser) {
        userService.updateAppUser(appUser);
    }

    /**
     * 管理后台给用户分配角色
     *
     * @param id      用户id
     * @param roleIds 角色ids
     */
    @PostMapping("/users/{id}/roles")
    public void setRoleToUser(@PathVariable Long id, @RequestBody Set<Long> roleIds) {
        userService.setRoleToUser(id, roleIds);
    }

    /**
     * 获取用户的角色
     *
     * @param id 用户id
     */
    @GetMapping("/users/{id}/roles")
    public Set<SysRole> findRolesByUserId(@PathVariable Long id) {
        return userService.findRolesByUserId(id);
    }


    /**
     * 绑定手机号
     *
     * @param phone 电话
     * @param key   钥匙
     * @param code  密码
     */
    @PostMapping(value = "/users/binding-phone")
    public void bindingPhone(String phone, String key, String code) {
        //TODO 绑定手机号
    }


    @Autowired
    public void setUserService(AppUserService userService) {
        this.userService = userService;
    }

}
