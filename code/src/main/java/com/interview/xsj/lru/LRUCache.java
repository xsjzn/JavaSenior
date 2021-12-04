package com.interview.xsj.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xsj
 * @create 2021-03-28 16:03
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int CACHE_SIZE;
    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75),0.75f,true);
        CACHE_SIZE=cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>CACHE_SIZE;
    }
}
