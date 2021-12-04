package chapter6.AQSLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于AQS实现的不可重入的独占锁
 * 核心是state变量的值
 * 1表示占用
 * 0表示未被占用
 * @author xsj
 * @create 2020-10-09 20:37
 */
public class NonReentrantLock implements Lock,java.io.Serializable {
    private static final long serialVersionUID = 7373982572414699L;
    /*内部帮助类
     * Base of synchronization control for this lock. Subclassed
     *  into fair and nonfair versions below. Uses AQS state to
     * represent only one thread can holds on the lock.
     */
    private static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -591235237620025860L;
        protected boolean isHeldExclusively(){
            return getState()==1;
        }
        protected final boolean tryAcquire(int acquires){
            assert acquires==1;
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        protected final boolean tryRelease(int releases){
            assert releases==1;
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        Condition condition(){
            return new ConditionObject();
        }

    }


    private final Sync sync=new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }
    public boolean isLocked(){
        return sync.isHeldExclusively();
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.condition();
    }
}
