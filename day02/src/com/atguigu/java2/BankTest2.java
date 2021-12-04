package com.atguigu.java2;

/**单例 (Singleton)设计模式，采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 *  并且该类只提供一个取得其对象实例的方法
 *  首先必须将类的构造器的访问权限设置为private
 *  只能调用该类的某个静态方法以返回类内部创建的对象，静态方法只能访问类中的静态成员变量，
 *  所以，指向类内部产生的该类对象的变量也必须定义成静态的
 * @author xsj
 * @create 2020-09-19 14:29
 */
public class BankTest2 {
}
class Bank2{
    private static Bank2 instance2=null;
    public static Bank2 getInstance2(){
        if(instance2==null){
            synchronized (Bank2.class){
                if(instance2==null){
                    instance2 =new Bank2();
                }
            }
        }
        return instance2;
    }
}
