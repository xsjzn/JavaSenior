package com.chapter8.pair1;

/**
 * @author xsj
 * @create 2020-10-27 17:52
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words={"Mary","had","a","little","lamb"};
        ArrayAlg.Pair<String> mm=ArrayAlg.minmax(words);
        System.out.println("min="+mm.getFirst());
        System.out.println("max="+mm.getSecond());
    }
}
class ArrayAlg{
    public static class Pair<T>{
        private T first;
        private T second;
        public Pair(T first,T second){
            this.first=first;
            this.second=second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
    }
    public static Pair<String> minmax(String[] a){
        if(a==null||a.length==0){
            return null;
        }
        String min=a[0];
        String max=a[0];
        //找出字典序最大和最小的
        for(int i=1;i<a.length;i++){
            if(min.compareTo(a[i])>0){
                min=a[i];
            }
            if(max.compareTo(a[i])<0){
                max=a[i];
            }
        }
        return new Pair<>(min,max);
    }

    /**
     * T…a并不是省略的意思，而是可变长度参数列表，
     * 表示此处接受的参数为0到多个Object类型的对象，或者是一个Object[]
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T...a){
        return a[a.length/2];
    }
}
