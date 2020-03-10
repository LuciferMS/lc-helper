package com.lc.helper.annotation;

import com.lc.helper.annotation.support.Types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: lc-helper
 * @description: 该注解带有题目的case信息
 * @author: Elliot
 * @create: 2020-03-10 13:50
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Case {

    String input();

    Types[] inputTypes();

    String expect();

    Types expectType();

}
