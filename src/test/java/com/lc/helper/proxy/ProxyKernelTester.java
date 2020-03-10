package com.lc.helper.proxy;

import com.lc.helper.testDemo.TestClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: lc-helper
 * @description: ProxyKernelTester
 * @author: Elliot
 * @create: 2020-03-10 00:40
 **/
public class ProxyKernelTester {


    private ProxyKernel<TestClass> proxyKernel;

    @Before
    public void init(){
        proxyKernel = new ProxyKernel<>();
    }

    /**
     * 代理被注解标记的方法
     * TODO 屏蔽目标方法调用逻辑
     */
    @Test
    public void targetMethodTest(){
        proxyKernel.handlerMethod(TestClass.class).targetTest();
    }

    @Test
    public void caseParseTest(){
        proxyKernel.handlerMethod(TestClass.class).caseTest(3, 5);
    }



}
