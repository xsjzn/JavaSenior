package com.interview.xsj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xsj
 * @create 2021-03-24 23:18
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",1233);
        //发送信息到服务器
        OutputStream os=socket.getOutputStream();
        InputStream is=socket.getInputStream();
        //发送一条信息
        os.write("你好我是客户端2".getBytes());
        while(true){
            if(is.available()>0){
                byte[] b=new byte[(is.available())] ;
                is.read(b);
                System.out.println("服务器说"+new String(b));
            }
        }

    }
}
