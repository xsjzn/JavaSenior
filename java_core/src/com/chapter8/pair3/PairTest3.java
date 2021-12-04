//package com.chapter8.pair3;
//
//import com.chapter8.Employee;
//import com.chapter8.Manager;
//
///**
// * @author xsj
// * @create 2020-10-28 18:56
// */
//public class PairTest3 {
//    public static void main(String[] args) {
//        var ceo=new Manager("jack",12312);
//        var cfo=new Manager("tim",23132);
//        var buddies=new Pair<Manager>(ceo,cfo);
//        printBuddies(buddies);
//
//        ceo.setBonus(12300);
//        cfo.setBonus(21312);
//
//        Manager[] managers={ceo,cfo};
//        var result=new Pair<Employee>();
//        minmaxBonus(managers,result);
//        System.out.println("first: "+ result.getFirst().getName()+
//                ",second: "+result.getSecond().getName());
//        maxminBonus(managers,result);
//        System.out.println("first: "+ result.getFirst().getName()+
//                ",second："+result.getSecond().getName());
//    }
//
//    public static void printBuddies(Pair<? extends Employee> buddies){
//        Employee first=buddies.getFirst();
//        Employee second=buddies.getSecond();
//        System.out.println(first.getName()+" and "+second.getName()+" are buddies");
//    }
//    public static void minmaxBonus(Manager[] a,Pair<? super Manager> result){
//        if(a.length==0){
//            return;
//        }
//        Manager min=a[0];
//        Manager max=a[0];
//        for(int i=1;i<a.length;i++){
//            if(min.getBonus()>a[i].getBonus()){
//                min=a[i];
//            }
//            if(max.getBonus()<a[i].getBonus()) {
//                max = a[i];
//            }
//        }
//        result.setFirst(min);
//        result.setSecond(max);
//    }
//
//    /**
//     * 实现为没有通配符的泛型方法
//     * @param a
//     * @param result
//     */
//    public static void maxminBonus(Manager[] a,Pair<? super Manager> result){
//        minmaxBonus(a,result);
//        PairAlg.swap(result);
////        PairAlg.swapHelper(result);
//    }
//}
//class PairAlg{
//    public static boolean hasNulls(Pair<?> p){
//        return p.getFirst()==null||p.getSecond()==null;
//    }
//    public static void swap(Pair<?> p){
//        swapHelper(p);
//    }
//    public static <T> void swapHelper(Pair<T> result) {
//        T t=result.getFirst();
//        result.setFirst(result.getSecond());
//        result.setSecond(t);
//    }
//}
