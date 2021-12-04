package com.interview.xsj.serialanddeserial;

import java.io.Serializable;

/**
 * @author xsj
 * @create 2021-05-12 17:44
 */

public class NY implements Serializable {
    private static final long serialVersionUID = 8891488565683643643L;
    private String name;
    private String blogName;

    @Override
    public String toString() {
        return "NY{" +
                "name='" + name + '\'' +
                ", blogName='" + blogName + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
}