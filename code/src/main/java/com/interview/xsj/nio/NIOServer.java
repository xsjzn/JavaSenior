package com.interview.xsj.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author xsj
 * @create 2021-04-20 15:07
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //1、获取Selector选择器
        Selector selector = Selector.open();

        // 2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3.设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 4、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8888));

        // 5、将通道注册到选择器上,并注册的操作为：“接收”操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 6、采用轮询的方式，查询获取“准备就绪”的注册过的操作
        while (true){
            if(selector.select() == 0){
                continue;
            }
            // 7、获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();

            while(selectedKeys.hasNext()){
                // 8、获取“准备就绪”的时间
                SelectionKey selectedKey = selectedKeys.next();

                // 9、判断key是具体的什么事件
                if (selectedKey.isAcceptable()) {
                    // 10、若接受的事件是“接收就绪” 操作,就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 11、切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 12、将该通道注册到selector选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectedKey.isReadable()){
                    // 13、获取该选择器上的“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectedKey.channel();

                    //14.读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length=0;
                    while((length=socketChannel.read(byteBuffer))!=-1){
                        //flip()：Buffer有两种模式，写模式和读模式。在写模式下调用flip()之后，Buffer从写模式变成读模式。
                        //那么limit就设置成了position当前的值(即当前写了多少数据)，postion会被置为0，以表示读操作从缓存的头开始读，mark置为-1。
                        //也就是说调用flip()之后，读/写指针position指到缓冲区头部，并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }

                // 15、移除选择键
                selectedKeys.remove();
            }

        }
    }
}
