package com.atguigu.exer3;

/**
 * @author xsj
 * @create 2020-09-18 21:42
 */
public class Consumer implements Runnable{//消费者
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while(true){
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}
