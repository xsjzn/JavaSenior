package com.chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用反射编写泛型数组代码
 * @author xsj
 * @create 2020-10-27 13:29
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a={1,2,3};
        a= (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));


    }
    public static Object[]
    badCopyOf(Object[] a,int newLength){//无效的 ，因为传进来数组 不是Object[] 但是属于Object
        Object[] newArray=new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }
    public static Object goodCopyOf(Object a,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()){
            return null;
        }
        Class componentType = cl.getComponentType();//返回数组中元素的Class对象，如果不是Class对象则返回null
        int length= Array.getLength(a);
        Object newArray=Array.newInstance(componentType,length);
        System.arraycopy(a,0,newArray,0,length);
        return newArray;
    }
}
