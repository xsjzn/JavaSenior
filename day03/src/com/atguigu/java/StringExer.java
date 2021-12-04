package com.atguigu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 1.模拟一个trim方法，去除字符串两端的空格。
 *
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 *
 * 3.获取一个字符串在另一个字符串中出现的次数。
 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
 中出现的次数

 4.获取两个字符串中最大相同子串。比如：
 str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
 提示：将短的那个串进行长度依次递减的子串与较长
 的串比较。

 5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
 提示：
 1）字符串变成字符数组。
 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
 3）将排序后的数组变成字符串。

 * @author xsj
 * @create 2020-09-19 17:16
 */
public class StringExer {
    //
    /**第2题
     * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     * @param str
     * @return
     */
    public String reverseStr(String str){
        StringBuilder res = new StringBuilder();
        char[] chars = str.toCharArray();
        for(int i=chars.length-1;i>=0;i++){
            res.append(chars[i]);
        }
        return res.toString();
    }
    // 第3题
    // 判断str2在str1中出现的次数
    public int getCount(String mainStr, String subStr){
        if(mainStr.length()>=subStr.length()){
            int count=0;
            int index=0;
            while((index=mainStr.indexOf(subStr,index))!=-1){
                count++;
                index+=subStr.length();
            }
            return count;
        }
        return 0;
    }

    /**如果存在多个长度相同的最大相同子串：使用ArrayList
     *4.获取两个字符串中最大相同子串。比如：
     str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
     提示：将短的那个串进行长度依次递减的子串与较长
     的串比较。
     * @param str1,str2
     * @return
     */
    public List<String> getMaxSameSubString1(String str1,String str2){
        if (str1 != null && str2 != null) {
            List<String> res=new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            String maxString=(str1.length()>str2.length())?str1:str2;
            String minString=(str1.length()<str2.length())?str1:str2;

            int len=minString.length();
            for(int i=0;i<len;i++){
                for(int x=0,y=len-i;y<len;x++,y++){
                    String subString=minString.substring(x,y);
                    if(maxString.contains(subString)){
                        res.add(subString);
                    }
                }
                if(res.size()!=0){
                    break;
                }
            }
            return res;
        }
        return null;
    }
/*    5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
    提示：
            1）字符串变成字符数组。
            2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
 3）将排序后的数组变成字符串。*/
    public String sortStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        StringExer se = new StringExer();
//        List<String> ans = se.getMaxSameSubString1("abcwerthelloyuiodef", "cvhellobnm");
//        System.out.println(ans);
        String strres = se.sortStr("sdasfasfa");
        System.out.println(strres);
    }
}
