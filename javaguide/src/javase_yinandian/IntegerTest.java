package javase_yinandian;

import org.junit.Test;

import java.util.Objects;

/**
 * 所有整型包装类对象值的比较必须使用equals方法。
 * @author xsj
 * @create 2020-10-08 20:25
 */
public class IntegerTest {
    @Test
    public void Test1(){
        Integer x=3;
        Integer y=3;
        System.out.println(x==y);//true
        Integer a=new Integer(3);
        Integer b=new Integer(3);
        System.out.println(a==b);//false
        System.out.println(Objects.equals(a,b));//ture
    }


}
