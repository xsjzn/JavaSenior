package chapter7.delayqueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author xsj
 * @create 2020-10-15 9:44
 */
public class TestDelay {
    static class DelayedEle implements Delayed {
        private final long delayTime;
        private final long expire;
        private final String taskName;

        public DelayedEle(long delay, String taskName) {
            delayTime=delay;
            this.taskName=taskName;
            expire=System.currentTimeMillis()+delay;
        }

        /**
         * 剩余时间=到期时间-当前时间
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        /**
         * 优先队列里面的优先级规则
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "DelayedEle{" +
                    "delayTime=" + delayTime +
                    ", expire=" + expire +
                    ", taskName='" + taskName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        DelayQueue<DelayedEle> delayQueue=new DelayQueue<>();
//        new PriorityBlockingQueue<>()
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            DelayedEle element=new DelayedEle(random.nextInt(1000),"Task"+i);
            delayQueue.offer(element);
        }
        //依次取出任务并打印
        DelayedEle ele= null;
        //3.1循环避免虚假唤醒
        try {
            for(;;){
                //3.2获取过期任务并打印
                while((ele=delayQueue.take())!=null){
                    System.out.println(ele.toString());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
