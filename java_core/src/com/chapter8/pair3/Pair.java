package com.chapter8.pair3;

/**
 * @author xsj
 * @create 2020-10-27 19:28
 */


public class Pair<T> {
    private T first;
    private T second;

    public Pair() {

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
 *
 * @param a
 * @param <T>
 * @return
 */

