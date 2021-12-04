package com.interview.xsj.bishi.ali329;

import java.util.Scanner;

/**

 小明和我参加班长的选举投票，投票人数为n，每人可以投K票，第一行输入为投票人数，第二行输入为每个人投给小明的票数求保证我能获胜最小的K。
 例如下面的示例，由于小明获得1+1+1+5+1=9票，则我获得4+4+4+0+4=12票，我获胜，此时5最小。
 输入：
 5
 1 1 1 5 1
 输出：
 5
 * @author xsj
 * @create 2021-04-02 16:02
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String num=sc.nextLine();

        String[] split = num.split("\\s+");
        int total=0;
        int maxScore=0;
        for(int i=0;i<split.length;i++){
            int score=Integer.parseInt(split[i]);
            total+=score;
            if(maxScore<score){
                maxScore=score;
            }
        }
        int k=maxScore;
        //k*n是总票数   total是小明的票数  当小明的票数不到一半时 我的票数就比小明的多
        while(k*n<=2*total){
            k++;
        }
        System.out.println(k);

    }
}
