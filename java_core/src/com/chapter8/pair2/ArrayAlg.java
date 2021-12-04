package com.chapter8.pair2;

/**
 * @author xsj
 * @create 2020-10-27 19:28
 */

public class ArrayAlg{
    public static class Pair<T>{
        public T first;
        public T second;
        public Pair(){

        }

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public void setSecond(T second) {
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
    }

    /**
     * 获得最小最大值 类或方法需要对类型变量加以约束
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a==null||a.length==0){
            return null;
        }
        T min=a[0];
        T max=a[0];
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
}
