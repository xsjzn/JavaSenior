package com.atguigu.com.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的举例
 * @author xsj
 * @create 2020-09-25 10:52
 */
interface Human{
    String getBelief();

    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}
/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。


 */
class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        //用被代理类进行赋值
        handler.bind(obj);
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxy = (Human) ProxyFactory.getProxyInstance(superMan);
        proxy.eat("麻辣烫");
        String belief = proxy.getBelief();
        System.out.println(belief);

        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxy1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeFactory);
        proxy1.produceCloth();
    }
}
