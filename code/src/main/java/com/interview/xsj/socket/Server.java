package com.interview.xsj.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xsj
 * @create 2021-03-24 23:13
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        //创建服务器容器对象，需要监听计算机中的某一个接口
//        ServerSocket server=new ServerSocket(2198);
//        //执行accept方法等待客户端连接，该方法是线程阻塞的
//        //如果没有客户端发送请求，该方法会阻塞当前线程
//        //如果有客户端发送了请求，该方法会进入执行状态并返回一个Socket对象
//        //该Socket对象只能用于和发送请求这一客户端进行通讯
//        Socket socket = server.accept();
//        System.out.println("有客户端连接请求到服务器");
//        //取出输入流
//        InputStream is = socket.getInputStream();
//        //取出输出流
//        OutputStream os = socket.getOutputStream();
//        //接受数据使用死循环来处理
//        while (true){
//            if(is.available()>0){
//                byte[] b=new byte[is.available()];
//                is.read(b);
//                System.out.println("客户端说"+new String(b));
//                os.write("你也好,这里是服务端 有什么需要服务".getBytes());
//            }
//        }
        //创建服务器套接字对象
        ServerSocket server=new ServerSocket(1233);
        while(true){
            System.out.println("服务器已开启正在等待客户端连接。。。。");
            //接受新的客户端请求
            Socket socket=server.accept();
            System.out.println("有新的客户端链接到了服务器");
            //开启一条新的线程用来接收该客户端发送的信息
            ServerReaderThread readThread=new ServerReaderThread(socket);
            //开始线程
            readThread.start();
        }

    }
}
