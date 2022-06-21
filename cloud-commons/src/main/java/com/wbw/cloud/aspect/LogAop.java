package com.wbw.cloud.aspect;

import com.alibaba.fastjson.JSONObject;
import com.wbw.cloud.annotation.LogRecord;
import com.wbw.cloud.model.Log;
import com.wbw.cloud.model.user.LoginAppUser;
import com.wbw.cloud.utils.AppUserUtil;
import com.wbw.cloud.utils.LogMqUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author wbw
 * @date 2022-6-13 0:33
 */
@Slf4j
@Aspect
@Component
public class LogAop {

    final
    LogMqUtil logClient;

    public LogAop(LogMqUtil logClient) {
        this.logClient = logClient;
    }

    @Pointcut("@annotation(com.wbw.cloud.annotation.LogRecord)")
    public void logPointCut() {}

    @Around(value = "logPointCut()")
    public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("start");
        Log record = new Log();
        record.setCreateTime(new Date());
        LoginAppUser loginAppUser = AppUserUtil.getLoginAppUser();
        if (loginAppUser != null) {
            record.setUsername(loginAppUser.getUsername());
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogRecord logRecord = methodSignature.getMethod().getDeclaredAnnotation(LogRecord.class);
        record.setModule(logRecord.module());

        if(logRecord.recordParam()) {
            String[] paramNames = methodSignature.getParameterNames();
            if(paramNames != null && paramNames.length > 0) {
                Object[] args = joinPoint.getArgs();
                Map<String, Object> params = new HashMap<>();
                for (int i = 0; i < paramNames.length; i++) {
                    Object value = args[i];
                    if (value instanceof Serializable) {
                        params.put(paramNames[i], value);
                    }
                }
                try {
                    record.setParams(JSONObject.toJSONString(params));
                } catch (Exception e) {
                    log.error("记录参数失败：{}", e.getMessage(), e);
                }
            }
        }

        try {
            Object object = joinPoint.proceed();
            record.setFlag(Boolean.TRUE);

            return object;
        } catch (Exception e) {
            record.setFlag(Boolean.FALSE);
            record.setRemark(e.getMessage());
            throw e;
        } finally {
            // 异步将Log对象发送到队列
            CompletableFuture.runAsync(() -> {
                try {
                    logClient.sendLogMsg(record);
                } catch (Exception e2) {
                    log.error(e2.getMessage(), e2);
                }
            });

        }

    }
}
