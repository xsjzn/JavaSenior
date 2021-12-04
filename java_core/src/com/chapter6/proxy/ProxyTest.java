package com.chapter6.proxy;

/**
 * This programme demonstrate the use of proxies
 * 使用代理对象跟踪一个二分查找
 * @author xsj
 * @create 2020-10-27 16:19
 */
//public class ProxyTest {
//    public static void main(String[] args) {
//        Object[] elements=new Object[1000];
//        for (int i = 0; i < elements.length; i++) {
//            Integer value=i+1;
//            var handler=new TraceHandler(value);
//            Object proxy= Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
//                    ,new Class[]{Comparable.class}, handler);
//            elements[i]=proxy;
//        }
//        Integer key=new Random().nextInt(elements.length)+1;
//        int result= Arrays.binarySearch(elements,key);//在代理对象上调用调用一个方法，就一定会完成invoke()这个动作
//        if(result>=0){
//            System.out.println(elements[result]);
//        }
//    }
//}
//class TraceHandler implements InvocationHandler{
//    private Object target;
//
//    public TraceHandler(Object target) {
//        this.target = target;
//    }
//
//    /**
//     *  打印所有调用方法的名字和参数
//     * @param proxy
//     * @param method
//     * @param args
//     * @return
//     * @throws Throwable
//     */
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.print(target);
//        System.out.print("."+ method.getName()+"(");
//        if(args!=null){
//            for (int i = 0; i < args.length; i++) {
//                System.out.print(args[i]);
//                if(i<args.length-1){
//                    System.out.print(", ");
//                }
//            }
//        }
//        System.out.println(")");
//        return method.invoke(target,args);
//    }
//}
