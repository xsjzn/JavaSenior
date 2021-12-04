package com.interview.xsj.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsj
 * @create 2021-05-14 12:04
 */
public class HeapOOM {
    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}