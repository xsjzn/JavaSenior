package com.interview.xsj.bishi.meituan.q2;

import java.util.Scanner;

/**
 * @author xsj
 * @create 2021-04-04 10:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] fenge=new int[n][2];
        for(int i=0;i<n;i++){
            fenge[i][0]=sc.nextInt();
            fenge[i][1]=sc.nextInt();
        }
        int cnt=1;
        for(int i=0;i<n;i++){
            //横切
           if(fenge[i][0]==0){
               cnt++;
           }
        }
        for(int i=0;i<n;i++){
            if(fenge[i][0]==1){
                //竖切
                int thres=fenge[i][1]>=180?fenge[i][1]-180:fenge[i][1];
                int st=thres;
                int ed=360-thres;
                for(int j=0;j<n;j++){
                    if(fenge[j][0]==0&&(fenge[j][1]>st&&fenge[j][1]<ed)){
                        cnt*=2;
                    }
                }
            }

        }
        System.out.println(cnt);
    }
}
