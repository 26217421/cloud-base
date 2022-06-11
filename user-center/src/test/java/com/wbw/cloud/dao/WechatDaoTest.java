package com.wbw.cloud.dao;

import com.wbw.cloud.model.user.WechatUserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatDaoTest {
    @Autowired
    WechatDao wechatDao;

    @Test
    public void findByOpenid() {
        System.out.println(wechatDao.findByOpenid("asasa"));
    }

    @Test
    public void findByUnionId() {
        wechatDao.findByUnionId("212121w").forEach(System.out::println);
    }

    @Test
    public void insert() {
        WechatUserInfo wechatUserInfo = new WechatUserInfo();
        wechatUserInfo.setOpenid("qqq");
        wechatUserInfo.setUnionid("212121w");
        wechatUserInfo.setApp("12112312");
        wechatUserInfo.setNickname("aaa");
        wechatUserInfo.setCreatetime(new Date());
        wechatUserInfo.setUpdatetime(new Date());
        wechatDao.insert(wechatUserInfo);
    }

    @Test
    public void deleteById() {
        wechatDao.deleteById(1);
        wechatDao.deleteById(3);
    }
}