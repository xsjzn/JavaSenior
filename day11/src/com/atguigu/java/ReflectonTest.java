package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xsj
 * @create 2020-09-23 22:15
 */
public class ReflectonTest {
    //反射之前，对于Person的操作
    @Test
    public void test1() {

        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }
    //反射之后，对于Person的操作
    @Test
    public void test2()  throws Exception{
        Class clazz = Person.class;
        //1通过反射，创建Person类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("TOM", 12);
        Person person= (Person) obj;
        System.out.println(person);
        //2.通过反射，调用对象指定的属性、方法
        //        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person);
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("*******************************");

        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器

        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);

    }

    @Test
    public void test3() throws ClassNotFoundException {
        //方式一 运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二 通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz2==clazz3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectonTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);

    }
    //万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作


    //Class实例可以是哪些结构的说明：
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }



}
