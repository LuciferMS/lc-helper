package com.lc.helper.annotation;

import java.lang.annotation.*;

/**
 * @program: lc-helper
 * @description: 方法标记，用改注解标记了的方法会被代理，经过一些列操作之后会被执行。
 * @author: Elliot
 * @create: 2020-03-10 00:22
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetMethod {
}
