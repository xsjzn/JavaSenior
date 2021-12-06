package com.interview.xsj.lru.withoutJdk;

import com.interview.xsj.lru.MyLRUCacheWithExpireTime;

public class TestLRU {

    public static void main(String[] args) {
        MyLRUCacheWithExpireTime cache = MyLRUCacheWithExpireTime.getInstance(100);
        cache.put("java", 1, 0);
        cache.put("c++",2,3000);
        System.out.println(cache.size());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cache.get("java"));
        Object o = cache.get("c++");
        System.out.println(o);


    }

}
