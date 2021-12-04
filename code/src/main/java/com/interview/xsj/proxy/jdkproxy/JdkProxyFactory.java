package com.interview.xsj.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**获取代理对象的工厂类
 * @author xsj
 * @create 2021-03-18 15:51
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target));// 代理对象对应的自定义 InvocationHandler
    }


}
