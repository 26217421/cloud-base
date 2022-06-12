package com.wbw.cloud.mq;

import com.wbw.cloud.utils.LogMqUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author wbw
 * @date 2022-6-12 16:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogMqTest {
    @Autowired
    LogMqUtil logClient;

    @Test
    public void sendLogMessage() throws InterruptedException {
        logClient.sendLogMsg("1","a","2","0",false);
        Thread.sleep(5000);
    }


}
