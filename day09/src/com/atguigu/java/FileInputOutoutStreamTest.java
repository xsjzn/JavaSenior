package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 * @author xsj
 * @create 2020-09-22 17:20
 */
public class FileInputOutoutStreamTest {
    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1提供File类对象，指明读取到的文件
            File file = new File("hello.txt");
            fis=new FileInputStream(file);

            byte[] buf=new byte[5];
            int len=0;
            while((len=fis.read(buf))!=-1){
                String str=new String(buf,0,len);
                System.out.println(str);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            //
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情2.jpg");
            fis=new FileInputStream(srcFile);
            fos=new FileOutputStream(destFile);
            byte[] buf=new byte[5];
            int len=-1;
            while((len=fis.read(buf))!=-1){
                fos.write(buf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            fis=new FileInputStream(srcFile);
            fos=new FileOutputStream(destFile);
            byte[] buf=new byte[1024];
            int len=-1;
            while((len=fis.read(buf))!=-1){
                fos.write(buf,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\Administrator\\Desktop\\01-视频.avi";
        String destPath = "C:\\Users\\Administrator\\Desktop\\02-视频.avi";


//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        copyFile(srcPath,destPath);


        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618

    }

}
