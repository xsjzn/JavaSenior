package com.atguigu.java.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端
 * 并关闭相应的连接。
 * @author xsj
 * @create 2020-09-23 20:19
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("爱情与友情.jpg"));
        //4
        byte[] buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //5.接收来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1=new byte[1024];
        int len1;
        while((len1=is.read(buffer1))!=-1){
            baos.write(buffer1,0,len1);
        }
        System.out.println(baos.toString());
        //6.
        fis.close();
        os.close();
        socket.close();
        baos.close();

    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] buffer=new byte[1024];
        FileOutputStream fos = new FileOutputStream(new File("爱情与友情4.jpg"));
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片传输完成");

        OutputStream os = socket.getOutputStream();
        os.write("你好，客户，你的照片收到啦，谢谢".getBytes());
        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
