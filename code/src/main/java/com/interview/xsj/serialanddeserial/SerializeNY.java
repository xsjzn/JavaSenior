package com.interview.xsj.serialanddeserial;

import java.io.*;

/**
 * @author xsj
 * @create 2021-05-12 17:44
 */
public class SerializeNY {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeNY();
        NY ny = deserializeNY();
        System.out.println(ny.toString());
    }

    private static void serializeNY() throws IOException {
        NY ny = new NY();
        ny.setName("NY");
        ny.setBlogName("NYfor2020");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\serialable.txt")));
        oos.writeObject(ny);
        System.out.println("NY 对象序列化成功！");
        oos.close();
    }

    private static NY deserializeNY() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\serialable.txt")));
        NY ny = (NY) ois.readObject();
        System.out.println("NY 对象反序列化成功");
        return ny;
    }
}