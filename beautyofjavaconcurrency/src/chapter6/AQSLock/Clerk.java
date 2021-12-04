package chapter6.AQSLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xsj
 * @create 2020-09-18 21:35
 */
public class Clerk {//售货员
    private int product=0;
    ReentrantLock lock=new ReentrantLock();
    Condition con1=lock.newCondition();
    Condition con2=lock.newCondition();
    public void addProduct(){
        lock.lock();
        try {
            if(product>=20){
                con1.await();
            }else {
                product++;
                System.out.println("生产者生产了位于仓库中第" + product + "个产品");
                con2.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void getProduct(){
        lock.lock();
        try {
            if(product<=0){
                con2.await();
            }else{
                System.out.println("消费者取走了位于仓库中第"+product+"个产品");
                product--;
                con1.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
