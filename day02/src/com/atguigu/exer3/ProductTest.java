package com.atguigu.exer3;

/**生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 果店中有产品了再通知消费者来取走产品。
 这里可能出现两个问题：
 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 消费者比生产者快时，消费者会取相同的数据。
 * @author xsj
 * @create 2020-09-18 21:44
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Thread productorThread = new Thread(new Productor(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));
        productorThread.start();
        consumerThread.start();

    }
}
