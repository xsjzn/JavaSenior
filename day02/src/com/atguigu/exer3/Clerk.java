package com.atguigu.exer3;

/**
 * @author xsj
 * @create 2020-09-18 21:35
 */
public class Clerk {//售货员
    private int product=0;
    public synchronized void addProduct(){
        if(product>=20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println("生产者生产了存于仓库中的第"+product+"个产品");
            notifyAll();
        }
    }
    public synchronized void getProduct(){
        if(product<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("消费者取走了存于仓库中的第"+product+"个产品");
            product--;
            notifyAll();
        }
    }
}
