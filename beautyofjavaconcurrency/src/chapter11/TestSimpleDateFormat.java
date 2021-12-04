package chapter11;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * NumberFormatException报错
 * @author xsj
 * @create 2020-10-24 19:19
 */
public class TestSimpleDateFormat {
    static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println(sdf.parse("2017-12-13 15:17:27"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
