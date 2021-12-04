package com.interview.xsj.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/** VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * @author xsj
 * @create 2021-05-14 16:11
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
