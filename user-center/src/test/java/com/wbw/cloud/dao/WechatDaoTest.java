package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.WechatUserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class WechatDaoTest {
    @Autowired
    WechatDao wechatDao;

    @Test
    public void findByOpenid() {
        wechatDao.findByOpenid("asasa");
    }

    @Test
    public void findByUnionId() {
    }

    @Test
    public void insert() {
        WechatUserInfo wechatUserInfo = new WechatUserInfo();
        wechatUserInfo.setOpenid("asasa");
        wechatUserInfo.setUnionid("212121w");
        wechatDao.insert(wechatUserInfo);
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}