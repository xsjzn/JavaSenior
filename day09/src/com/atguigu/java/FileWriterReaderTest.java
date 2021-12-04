package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一.流的分类
 * 1。操作数据的单位：字节流、字符流
 * 2.数据的流向：输入流 输出流
 * 3.流的角色：节点流、处理流
 * 二、流的体系结构
 * 抽象基类：          节点流（文件流）         缓冲流（处理流的一种）
 * InputStream         FileInputStream          BufferedInputStream
 * OutputStream        FileOutputStream         BufferedOutputStream
 * Reader              FileReader               BufferedReader
 * Writer              FileWriter               BufferedWriter
 * @author xsj
 * @create 2020-09-22 11:58
 */
public class FileWriterReaderTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }
    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。

     */
    @Test
    public void testFileReader() throws IOException {

//        FileReader fr=new FileReader(file);
        FileReader fr=null;
        try{
            //1.实例化file对象
            File file = new File("hello.txt");//相较于当前module
            //2.提供具体的流
            fr=new FileReader(file);
//        while(data!=-1){
//            data=fr.read();
//            System.out.print((char)data);
//        }
            //数据的读入
            int data;
            while ((data=fr.read())!=-1){
                System.out.println((char)data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4,流的关闭操作
            if(fr!=null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

        }

    }

    /**
     * 从内存中写出数据到硬盘文件里
     *  说明：
     1. 输出操作，对应的File可以不存在的。并不会报异常
     2.
     File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     File对应的硬盘中的文件如果存在：
     如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖(是默认值)
     如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter()  {
        FileWriter fw = null;
        try {
            //1提供File类对象，指明写出到的文件
            File file =new File("hello1.txt");
            //2.提供filewriter对象，用于数据的写出
            fw = new FileWriter(file,true);
            //3.写出的操作
            fw.write("YOU NEED A DREAM");
            fw.write("I have A DREAM");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流的操作
            if(fw!=null){

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try{
            //1提供File类对象，指明写出到的文件
            File srcFile = new File("hello.txt");
            File desFile = new File("hello2.txt");
            //2提供FileReader和FileWriter对象
            fr=new FileReader(srcFile);
            fw=new FileWriter(desFile);
            ////3.数据的读入和写出操作
            char[] cbuf= new char[5];
            int len;//记录每次读入到cbuf中的字符的个数
            while((len=fr.read(cbuf))!=-1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //4.关闭流资源
            //方式一：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
