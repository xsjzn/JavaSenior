package chapter6.AQSLock;

/**
 * @author xsj
 * @create 2020-10-10 21:33
 */
public class ProConTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Thread productorThread = new Thread(new Productor(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));
        productorThread.start();
        consumerThread.start();
    }
}
