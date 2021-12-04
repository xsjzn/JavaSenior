package com.atguigu.java.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 * @author xsj
 * @create 2020-09-23 17:10
 */
public class TCPTest1 {
    @Test
    public void Client()  {
        Socket socket=null;
        OutputStream os=null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet1 = InetAddress.getByName("127.0.0.1");
            socket=new Socket(inet1,8899);
            //2.获取一个输出流
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.资源的关闭
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    @Test
    public void Server() throws IOException {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer=new byte[20];
            int len;
            while((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到来自于"+socket.getInetAddress().getHostAddress()+"的数据");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos!=null){
                baos.close();
            }
            if(is!=null){
                is.close();
            }
            if(socket!=null){
                socket.close();
            }
            if(serverSocket!=null){
                serverSocket.close();
            }
        }
    }

}
