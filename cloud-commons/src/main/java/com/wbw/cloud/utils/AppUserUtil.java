package com.wbw.cloud.utils;

import com.wbw.cloud.model.user.LoginAppUser;

/**
 * @author wbw
 * @since 2022-6-8 20:34
 */
public class AppUserUtil {
    public static LoginAppUser getLoginAppUser() {
        LoginAppUser loginAppUser = new LoginAppUser();
        loginAppUser.setUsername("aa");
        return loginAppUser;
    }
}
