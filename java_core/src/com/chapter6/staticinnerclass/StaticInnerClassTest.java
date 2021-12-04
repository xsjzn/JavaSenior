package com.chapter6.staticinnerclass;

/**
 * @author xsj
 * @create 2020-10-27 15:30
 */
//public class StaticInnerClassTest {
//    public static void main(String[] args) {
//        var values=new double[20];
//        for (int i = 0; i < values.length; i++) {
//            values[i]=100*Math.random();
//        }
//        ArrayAlg.Pair minmax = ArrayAlg.minmax(values);
//        System.out.println("min="+minmax.getFirst());
//        System.out.println("max="+minmax.getSecond());
//    }
//}
//class ArrayAlg{
//    public static class Pair{
//        private double first;
//        private double second;
//        public Pair(double first,double second){
//            this.first=first;
//            this.second=second;
//        }
//
//        public double getFirst() {
//            return first;
//        }
//
//        public double getSecond() {
//            return second;
//        }
//    }
//    public static Pair minmax(double[] values){
//        double min=Double.POSITIVE_INFINITY;
//        double max=Double.NEGATIVE_INFINITY;
//        for(double v: values){
//            if(min>v){
//                min=v;
//            }
//            if(max<v){
//                max=v;
//            }
//        }
//        return new Pair(min,max);
//    }
//}
