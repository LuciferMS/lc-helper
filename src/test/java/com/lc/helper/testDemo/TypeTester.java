package com.lc.helper.testDemo;

import org.junit.Test;

/**
 * @program: lc-helper
 * @description: 类型测试
 * @author: Elliot
 * @create: 2020-03-10 11:40
 **/
public class TypeTester {

    static class Tester<T> {
        public void printClass(){

        }
    }

    @Test
    public void printTest(){
        Tester<String> tester = new Tester<String>();
    }
}
