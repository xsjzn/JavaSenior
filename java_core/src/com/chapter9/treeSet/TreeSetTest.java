//package com.chapter9.treeSet;
//
//import java.util.Comparator;
//import java.util.TreeSet;
//
///**
// * @author xsj
// * @create 2020-10-29 19:12
// */
//public class TreeSetTest {
//    public static void main(String[] args) {
//        var parts=new TreeSet<Item>();
//        parts.add(new Item("Tastor",1234));
//        parts.add(new Item("asdasdq",123234));
//        parts.add(new Item("Barbeque",112434));
//        System.out.println(parts);
//        TreeSet<Item> items = new TreeSet<>(Comparator.comparing(Item::getDescription));
//        items.addAll(parts);
//        System.out.println(items);
//
//    }
//}
