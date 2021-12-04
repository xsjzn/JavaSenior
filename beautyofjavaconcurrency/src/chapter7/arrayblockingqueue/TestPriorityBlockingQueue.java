package chapter7.arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author xsj
 * @create 2020-10-15 15:28
 */
public class TestPriorityBlockingQueue {
    static class Task implements Comparable<Task>{
        private int priority=0;
        private String taskName;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public int compareTo(Task o) {
            if(this.priority>=o.priority){
                return 1;
            }else{
                return -1;
            }
        }
        public void doSomething(){
            System.out.println(taskName+":"+priority);
        }
    }

    public static void main(String[] args) {
        //创建任务，并添加到队列
        PriorityBlockingQueue<Task> priorityBlockingQueue=new PriorityBlockingQueue<>();
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskName"+i);
            priorityBlockingQueue.offer(task);
        }
        //取出任务执行
        while(!priorityBlockingQueue.isEmpty()){
            Task task = priorityBlockingQueue.poll();
            if(task!=null){
                task.doSomething();
            }
        }
    }

}
