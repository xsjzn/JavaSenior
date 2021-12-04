package chapter6.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A 执行完调用B，B执行完调用C，C执行完调用A
 * @author xsj
 * @create 2020-10-09 15:49
 */
public class AQSTest {
    public static void main(String[] args) {
        Data3 data3=new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();

    }
}
class Data3{
    ReentrantLock lock=new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private int num=1;
    public void printA(){
        lock.lock();
        try {
            while (num!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>AAAA");
            num=2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (num!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"BBBB");
            num=3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (num!=3){
                condition3.await();
            }

            System.out.println(Thread.currentThread().getName()+"CCCC");
            num=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
