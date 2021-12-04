package javase_yinandian;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 《阿里巴巴Java开发手册》中提到,浮点数之间的等值判断，
 * 基本数据类型不用用==来判断(精读损失)，包装数据类型不能用equals来判断，具体原理与浮点数的编码方式有关
 * 要注意==对于基本数据类型比较的是
 * @author xsj
 * @create 2020-10-08 20:10
 */
public class Bigdemical {
    @Test
    public void Test1(){

        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);//false （精度丢失)

    }
    @Test
    public void Test2(){
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.1");
        BigDecimal c = new BigDecimal("1.2");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        System.out.println(x);//-0.1
        System.out.println(y);//-0.1
        System.out.println(x==y);//false
        System.out.println(Objects.equals(x,y));//true
    }
    @Test
    public void Test3(){
        //1表示a比b大
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.compareTo(b));
    }
//    通过 setScale方法设置保留几位小数以及保留规则。保留规则有挺多种，不需要记，IDEA会提示。
    @Test
    public void Test4(){
        BigDecimal bigDecimal = new BigDecimal("1.254431");
        BigDecimal n1 = bigDecimal.setScale(3, RoundingMode.UP);
        BigDecimal n2 = bigDecimal.setScale(3, RoundingMode.CEILING);
        BigDecimal n3 = bigDecimal.setScale(3, RoundingMode.FLOOR);
        BigDecimal n4 = bigDecimal.setScale(3, RoundingMode.HALF_EVEN);
        BigDecimal n5 = bigDecimal.setScale(3, RoundingMode.HALF_DOWN);//四舍侮辱
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
    }
    //BigDecimal 主要用来操作（大）浮点数，BigInteger 主要用来操作大整数（超过 long 类型）。
    //
    //BigDecimal 的实现利用到了 BigInteger, 所不同的是 BigDecimal 加入了小数位的概念
}
