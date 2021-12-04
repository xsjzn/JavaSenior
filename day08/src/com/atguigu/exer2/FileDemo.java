package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author xsj
 * @create 2020-09-22 11:27
 */
public class FileDemo {
    @Test
    public void Test1() throws IOException {
        File file = new File("d:\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另一个文件 haha.txt
        File file1 = new File(file.getParent(), "haha.txt");
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
    }
    @Test
    public void Test2(){

    }
}
