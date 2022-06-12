package com.wbw.cloud.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 * @author wbw
 * @since 2022-6-6 19:31
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {

    /**
     * 日志模块
     *
     * @return 日志模块
     * @see com.wbw.cloud.constants.LogModule
     */
    String module();

    /**
     * 记录参数<br>
     * 尽量记录普通参数类型的方法，和能序列化的对象
     *
     * @return 是否记录
     */
    boolean recordParam() default true;
}
