package com.lc.helper.proxy;

import com.lc.helper.annotation.Case;
import com.lc.helper.annotation.TargetMethod;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: lc-helper
 * @description: 核心代理类，用动态代理处理项目的核心逻辑
 * @author: Elliot
 * @create: 2020-03-10 00:26
 **/
public class ProxyKernel<T> {

    static class KernelBuilder {

        private Enhancer enhancer = new Enhancer();

        public KernelBuilder setSuperClass(Class clz) {
            enhancer.setSuperclass(clz);
            return this;
        }

        public KernelBuilder setCallBack(MethodInterceptor methodInterceptor){
            enhancer.setCallback(methodInterceptor);
            return this;
        }

        public KernelBuilder setCallBack(){
            enhancer.setCallback(DEFAULT_INTERCEPTOR);
            return this;
        }

        public Enhancer build(){
            return enhancer;
        }

        private final MethodInterceptor DEFAULT_INTERCEPTOR = new MethodInterceptor() {
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                //TODO 完善注解的解释逻辑
                if (method.isAnnotationPresent(TargetMethod.class)){
                    //TODO 解析case注解
                    if (method.isAnnotationPresent(Case.class)){
                        Case c = method.getDeclaredAnnotation(Case.class);
                        System.out.println(c.input());
                        System.out.println(c.expect());
                    }
                    System.out.println("被TargetMethod注解标记的方法被执行前.....");
                    Object result = proxy.invokeSuper(obj, args);
                    System.out.println("被TargetMethod注解标记的方法被执行后.....");
                    return result;
                }else {
                    Object result = proxy.invokeSuper(obj, args);
                    return result;
                }
            }
        };
    }

    /**
     * 处理方法代理逻辑
     */
    public T handlerMethod(Class clz){
        KernelBuilder kernelBuilder = new KernelBuilder();
        Enhancer enhancer = kernelBuilder.setSuperClass(clz).setCallBack().build();
        return (T)enhancer.create();
    }


}
