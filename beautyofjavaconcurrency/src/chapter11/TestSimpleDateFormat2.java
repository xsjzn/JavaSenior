package chapter11;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author xsj
 * @create 2020-10-24 19:19
 */
public class TestSimpleDateFormat2 {
    static ThreadLocal<SimpleDateFormat> safeSdf=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println(safeSdf.get().parse("2017-12-12 15:17:27"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }finally {
                    safeSdf.remove();
                }
            }).start();
        }
    }
};





