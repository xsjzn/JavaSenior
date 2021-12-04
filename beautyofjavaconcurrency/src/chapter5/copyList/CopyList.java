package chapter5.copyList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xsj
 * @create 2020-10-09 11:48
 */
public class CopyList {
    private static volatile CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hust");
        Thread one =new Thread(()->{
            arrayList.set(1,"baba");
            arrayList.remove(2);
            arrayList.remove(3);
        });
        Iterator<String> iterator = arrayList.iterator();
        one.start();
        one.join();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str+" ");
        }

    }
}
