package com.interview.xsj.mianshi.meituan0412;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here

        char[] cs= s.toCharArray();
        char[] ct= t.toCharArray();
        //进位
        int carry=0;
        int i=cs.length,j=ct.length;

        StringBuilder sb=new StringBuilder();
        while(i!=0&&j!=0&&carry!=0){
            int x=i<=0?0:cs[i]-'0';
            int y=j<=0?0:ct[i]-'0';
            sb.append((x+y+carry)%10);
            carry=(x+y+carry)/10;
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String solve = solution.solve("123", "99");
    }
}