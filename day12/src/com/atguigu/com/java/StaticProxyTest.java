package com.atguigu.com.java;

/** * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 * @author xsj
 * @create 2020-09-24 17:34
 */
interface ClothFactory{
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}
//被代理类对象
class NikeFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("生产了一批nike运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        ClothFactory nikeFactory = new NikeFactory();
        //创建代理类对象
        ClothFactory proxyFactory = new ProxyClothFactory(nikeFactory);
        proxyFactory.produceCloth();
    }

}
