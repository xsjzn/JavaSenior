package com.atguigu.java1;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author xsj
 * @create 2020-09-21 19:39
 */
public class PropertiesTest {
    //Properties 里的 key和 value 都是字符串类型,主要用于配置文件
    //存取数据时，建议使用setProperty(String key,String value)方法和
    //getProperty(String key)方法
    //Properties pros = new Properties();
    //pros.load(new FileInputStream("jdbc.properties
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println(name+"---->"+password);


    }
}
