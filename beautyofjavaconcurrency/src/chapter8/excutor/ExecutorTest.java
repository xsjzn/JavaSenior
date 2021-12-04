package chapter8.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阿里巴巴java开发手册不建议使用Executors工具类，因为用Executors创建的线程池可能会堆积大量的请求，
 * 导致发生OOM
 * @author xsj
 * @create 2020-10-15 21:24
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        executorService.execute(()->{
            for (int i = 0; i < 100; i++) {
                if(i%2==1){
                    System.out.println(Thread.currentThread().getName() + ": "+i);
                }
            }
        });
        executorService1.execute(()->{
            for (int i = 0; i < 100; i++) {
                if(i % 2 != 0){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        });
    }

}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
