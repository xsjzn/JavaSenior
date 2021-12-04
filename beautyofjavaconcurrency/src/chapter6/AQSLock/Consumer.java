package chapter6.AQSLock;

/**
 * @author xsj
 * @create 2020-10-10 21:29
 */
public class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println("消费者开始消费");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}
