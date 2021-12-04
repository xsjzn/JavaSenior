package com.interview.xsj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xsj
 * @create 2021-03-24 23:18
 */
public class ServerReaderThread extends Thread {
    //定义一个Socket对象通过构造方法来赋值将main主线程的Socket对象传进来
    private Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        //获取套接字中的输入流
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            while (true){
                //如果输入流的信息长度大于零
                if(is.available()>0){
                    byte[] b=new byte[is.available()];
                    is.read(b);//读
                    System.out.println("客户端说"+new String(b));

                    //回复
                    os.write("欢迎光临".getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
