package com.interview.xsj.ProducerAndConsumer;

/**
 * @author xsj
 * @create 2021-05-22 9:54
 */
public class ConsumeThread extends Thread {
    private Consumer c;
    public ConsumeThread(Consumer c){
        this.c = c;
    }
    @Override
    public void run() {
        while (true) {
            c.consume();
        }
    }
}
