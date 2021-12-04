package com.chapter8;

/**
 * 构造pair<T>类型的实例
 * @author xsj
 * @create 2020-10-28 11:14
 */
//public class pairTest {
//    public static void main(String[] args) {
//        ArrayAlg.Pair<String> p = makePair(String::new);
//        ArrayAlg.Pair<String> s = makePair(String.class);
//        String[] names=minmax(String[]::new,"TOM","DICK","HARRY");
//        for (int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//        }
////        System.out.println(p);
////        System.out.println(s);
//    }
//    public static <T> ArrayAlg.Pair<T> makePair(Supplier<T> constr){
//        return new ArrayAlg.Pair<>(constr.get(),constr.get());
//    }
//    public static <T> ArrayAlg.Pair<T> makePair(Class<T> cl){
//        try {
//            return new ArrayAlg.Pair<>(cl.getConstructor().newInstance(),cl.getConstructor().newInstance());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 新方法 提供数组构造器表达式
//     * @param constr
//     * @param a
//     * @param <T>
//     * @return
//     */
//    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr,T... a){
//        T[] result =constr.apply(2);
//        result[0]=a[0];
//        result[1]=a[0];
////        T min=a[0],max=a[0];
//        for(int i=1;i<a.length;i++){
//            if(result[0].compareTo(a[i])>0){
//                result[0]=a[i];
//            }
//            if(result[1].compareTo(a[i])<0){
//                result[1]=a[i];
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 老式方法构造泛型数组
//     * @param a
//     * @param <T>
//     * @return
//     */
//    public static <T extends Comparable> T[] minmax_Old(T... a){
////        var result=(T[]) Array.newInstance(a.getClass().getComponentType(),2);
//        result[0]=a[0];
//        result[1]=a[0];
////        T min=a[0],max=a[0];
//        for(int i=1;i<a.length;i++){
//            if(result[0].compareTo(a[i])>0){
//                result[0]=a[i];
//            }
//            if(result[1].compareTo(a[i])<0){
//                result[1]=a[i];
//            }
//        }
//        return result;
//    }
//    public static void printBuddies(ArrayAlg.Pair<? extends Employee> p){
//
//    }
//    public static void minmaxBonus(Executive[] a, ArrayAlg.Pair<?super Manager> result){
//        if(a.length==0){
//            return ;
//        }
//        Executive min=a[0];
//        Executive max=a[0];
//        for(int i=1;i<a.length;i++){
//            if(min.getBonus()>a[i].getBonus()){
//                min=a[i];
//            }
//            if(max.getBonus()<a[i].getBonus()){
//                max=a[i];
//            }
//        }
//        result.setFirst(min);
//        result.setSecond(max);
//    }
//}
