package com.lc.helper.testDemo;

import com.lc.helper.annotation.Case;
import com.lc.helper.annotation.TargetMethod;
import com.lc.helper.annotation.support.Types;

/**
 * @program: lc-helper
 * @description: 测试类
 * @author: Elliot
 * @create: 2020-03-10 00:21
 **/
public class TestClass {

    @TargetMethod
    public void targetTest(){
        System.out.println("这是一个测试方法");
    }

    @TargetMethod
    @Case(input = "3, 5", inputTypes = {Types.INT, Types.INT}, expect = "8", expectType = Types.INT)
    public int caseTest(int n, int k){
        return n + k;
    }

}
