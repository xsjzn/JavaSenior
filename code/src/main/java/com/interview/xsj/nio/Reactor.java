package com.interview.xsj.nio;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;



/**
 * @author xsj
 * @create 2021-04-19 19:46
 */
class Reactor implements Runnable {
    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException {
        //1、获取Selector选择器
        selector = Selector.open();
        //2、获取通道
        serverSocket = ServerSocketChannel.open();
        //3、绑定连接
        serverSocket.socket().bind(
                new InetSocketAddress(port));
        //4、设置为非阻塞
        serverSocket.configureBlocking(false);
        // 5、将通道注册到选择器上,并注册的操作为：“接收”操作
        SelectionKey sk =
                serverSocket.register(selector,
                        SelectionKey.OP_ACCEPT);
        //6、新建一个Acceptor分发器 关联到serverSocket
        sk.attach(new Acceptor());
    }
    public void run() { // normally in a new Thread

        try {
            while (!Thread.interrupted()) {
                //select函数 阻塞式的 至少有一个I/O事件就绪，才会返回
                selector.select();
                //得到selectedKeys
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                //遍历selectedKeys 用Acceptor分配
                while (it.hasNext()){
                    dispatch((SelectionKey)(it.next()));
                }
                //都执行完了，清空selectedKeys
                selected.clear();
            }
        } catch (IOException ex) { /* ... */ }
    }
    void dispatch(SelectionKey k) {
        //通过选择见检索到当前附加的对象也就是Acceptor 去执行
        Runnable r = (Runnable)(k.attachment());
        if (r != null)
            r.run();
    }
    class Acceptor implements Runnable { // inner
        public void run() {
            try {
                SocketChannel c = serverSocket.accept();
                //新建一个handler去执行（读或写）channel
                if (c != null)
                    new Handler(selector, c);
            }
            catch(IOException ex) { /* ... */ }
        }
    }
}