package chapter4.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

/**
 * @author xsj
 * @create 2020-10-08 9:22
 */
public class Atomic {
//    private static AtomicLong atomicLong=new AtomicLong();
//    private static LongAdder longAdder=new LongAdder();
    private static LongAccumulator longAccumulator=new LongAccumulator(new LongBinaryOperator() {
    @Override
    public long applyAsLong(long left, long right) {
        return left+right;
    }
},2);

    //2创建数据源

    private static Integer[] arrayOne=new Integer[]{1,0,0,0,1,2,3,4,1,10,23,0};
    private static Integer[] arrayTwo=new Integer[]{3,1,4,5,0,0,12,30,3,0,0,1,0};
    private static Integer[] arrayThree=new Integer[]{0,0,4,5,0,0,12,30,3,0,0,1,0};

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int size=arrayOne.length;
            for(int i=0;i<size;i++){
                if(arrayOne[i].intValue()==0){
//                    atomicLong.incrementAndGet();
//                    longAdder.increment();
                    longAccumulator.accumulate(1);
                }
            }
        }).start();
        new Thread(()->{
            int size=arrayTwo.length;
            for(int i=0;i<size;i++){
                if(arrayTwo[i].intValue()==0){
//                    atomicLong.incrementAndGet();
//                    longAdder.increment();
                    longAccumulator.accumulate(1L);
                }


            }
        }).start();
        new Thread(()->{
            int size=arrayTwo.length;
            for(int i=0;i<size;i++){
                if(arrayThree[i].intValue()==0){
//                    atomicLong.incrementAndGet();
//                    longAdder.increment();
                    longAccumulator.accumulate(1L);
                }

            }
        }).start();
        Thread.sleep(1000);
        System.out.println(longAccumulator.get());
    }

}
