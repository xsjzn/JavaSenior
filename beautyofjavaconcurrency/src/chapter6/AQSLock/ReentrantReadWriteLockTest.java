package chapter6.AQSLock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xsj
 * @create 2020-10-11 16:28
 */
public  class ReentrantReadWriteLockTest {


    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockList list=new ReentrantReadWriteLockList();
        for (int i = 0; i < 10; i++) {
            final int e=i;
            new Thread(()->{
                list.add("abs"+String.valueOf(e));
            }).start();
        }
//        new ArrayBlockingQueue<>()
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            final int e=i;
            new Thread(()->{
                String s = list.get(e);
                System.out.println("成功获取"+s);
            }).start();

        }
        for (int i = 0; i < 10; i++) {
            final int e=i;
            new Thread(()->{
                list.add("abs"+String.valueOf(e));
            }).start();
        }

    }
}
class ReentrantReadWriteLockList{
    private ArrayList<String> array=new ArrayList<>();
    //独占锁
    public final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private final Lock readLock=lock.readLock();
    private final Lock writeLock=lock.writeLock();

    public void add(String s){
        writeLock.lock();
        try {
            array.add(s);
            System.out.println("成功添加"+s);
        } finally {
            writeLock.unlock();
        }
    }
    public void remove(String e){
        writeLock.lock();
        try {
            array.remove(e);
        } finally {
            writeLock.unlock();
        }
    }
    public String get(int index){
        readLock.lock();
        try {
            return array.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
