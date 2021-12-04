package com.interview.xsj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xsj
 * @create 2021-03-24 23:08
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //通过socket对象向服务器发送请求
        Socket socket = new Socket("localhost", 2198);
        //创建的socket对象是计算机客户端通讯的端点
        //该通讯的端点用于和服务器通讯
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //通过输出流将数据发送到通讯的另一端
        os.write("你好，我是客户端1".getBytes());

        while(true){
            if(is.available()>0){
                byte[] b=new byte[is.available()];
                is.read(b);
                System.out.println("服务端回复说"+new String(b));
            }
        }
    }
}
