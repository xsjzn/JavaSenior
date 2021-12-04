package com.atguigu.exer3;

/**
 * @author xsj
 * @create 2020-09-18 21:40
 */
public class Productor implements Runnable {//生产者
    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while(true){
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}
