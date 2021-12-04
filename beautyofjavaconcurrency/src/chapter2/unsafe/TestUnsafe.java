package chapter2.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author xsj
 * @create 2020-10-06 17:11
 */
public class TestUnsafe {
    static  Unsafe unsafe;
    static  long stateOffset;
    private volatile long state;
    static {
        Field field = null;
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe=(Unsafe)field.get(null);
            //获取state在TestUnsafe中的偏移量
            stateOffset=unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnsafe test = new TestUnsafe();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }

}
