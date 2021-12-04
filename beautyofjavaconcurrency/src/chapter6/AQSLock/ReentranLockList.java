package chapter6.AQSLock;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xsj
 * @create 2020-10-11 15:29
 */
public class ReentranLockList {
    private ArrayList<String> array=new ArrayList<>();
    private volatile ReentrantLock lock =new ReentrantLock();
    //添加元素
    public void add(String e){
        lock.lock();
        try {

            array.add(e);
            System.out.println("添加成功"+e);
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //删除元素
    public void remove(String e){
        lock.lock();
        try {
            array.remove(e);
            System.out.println("删除成功"+e);
        } finally {
            lock.unlock();
        }
    }
    //获取数据
    public String get(int index){
        lock.lock();
        try {
            return array.get(index);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranLockList list = new ReentranLockList();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add("abc");
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.remove("abc");
            }).start();
        }

    }

}
