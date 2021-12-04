package chapter6.AQSLock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

/**
 * @author xsj
 * @create 2020-10-09 21:10
 */
public class NonReentrantLockTest {
    final static NonReentrantLock LOCK=new NonReentrantLock();
    final static Condition notFull= LOCK.newCondition();
    final static Condition notEmpty=LOCK.newCondition();

    final static Queue<String> queue=new LinkedBlockingDeque<>();
    final static int queueSize=5;

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {

                LOCK.lock();
                try {
                    while (queue.size() == queueSize) {
                        notEmpty.wait();
                    }
                    //添加元素到队列
                    queue.add("ele");
                    System.out.println("客官，包子做好了");
                    //唤醒消费线程
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            }
        });
        Thread consumer =new Thread(()->{
            LOCK.lock();
            try {
                while(0==queue.size()){
                    notFull.await();
                }
                //消费一个元素
                String ele=queue.poll();
                System.out.println("我吃完啦！");
                //唤醒生产线成
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                LOCK.unlock();
            }
        });
        producer.start();
        consumer.start();
    }
}
