package chapter6.AQSLock;

/**
 * @author xsj
 * @create 2020-10-10 21:31
 */
public class Productor implements Runnable{
    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}
