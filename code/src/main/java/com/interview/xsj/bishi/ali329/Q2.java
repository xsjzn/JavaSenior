package com.interview.xsj.bishi.ali329;

import java.util.Scanner;

/**leetcode1334
 *
 * 要求n个城市中有m条道路，求在距离d以内，从一个城市到其它城市的数量最少，
 * 如遇到数量相同，则选择输出编号最大的那个城市。
 * 第一行，测试数据的组数：t组
 * 第二行：n（城市数量） m（道路条数） d（要求距离）
 * 接下来m行：l（城市编号） r（城市编号） w（距离）
 * @author xsj
 * @create 2021-04-02 16:33
 */
public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String[] split=sc.nextLine().split("\\s+");
            int n=Integer.valueOf(split[0]);
            int m=Integer.valueOf(split[1]);
            int distanceThreshold=Integer.valueOf(split[2]);
            //建图
            int[][] map=new int[n][n];
            //init
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        map[i][j]=0;
                    }else{
                        map[i][j]=Integer.MAX_VALUE;
                    }
                }
            }

            for(int i=0;i<m;i++){
                String[] edges=sc.nextLine().split("\\s+");
                Integer city1 = Integer.valueOf(edges[0]);
                Integer city2 = Integer.valueOf(edges[1]);
                Integer cost = Integer.valueOf(edges[2]);
                map[city1][city2]=map[city2][city1]=cost;
            }
            //floyd
            for(int k=0;k<n;k++){//中间点
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i==k||k==j||i==j||map[i][k]==Integer.MAX_VALUE||map[k][j]==Integer.MAX_VALUE){
                            continue;
                        }
                        map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                    }
                }
            }
            //统计结果
            int res=-1;
            int minCount=n+1;
            for(int i=0;i<n;i++){
                int count=0;
                for(int j=0;j<n;j++){
                    if(i!=j&&map[i][j]<=distanceThreshold){
                        count++;
                    }
                }
                if(minCount>=count){
                    minCount=count;
                    res=i;
                }
            }
            System.out.println(res);
        }


    }

    /**
     * leetcode1334
     */
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            //建图
            int[][] map=new int[n][n];
            //init
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        map[i][j]=0;
                    }else{
                        map[i][j]=Integer.MAX_VALUE;
                    }
                }
            }

            //填充边
            for(int[] e:edges){
                map[e[0]][e[1]]=map[e[1]][e[0]]=e[2];
            }
            //floyd
            for(int k=0;k<n;k++){//中间点
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i==k||k==j||i==j||map[i][k]==Integer.MAX_VALUE||map[k][j]==Integer.MAX_VALUE){
                            continue;
                        }
                        map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                    }
                }
            }
            //统计结果
            int res=-1;
            int minCount=n+1;
            for(int i=0;i<n;i++){
                int count=0;
                for(int j=0;j<n;j++){
                    if(i!=j&&map[i][j]<=distanceThreshold){
                        count++;
                    }
                }
                if(minCount>=count){
                    minCount=count;
                    res=i;
                }
            }
            return res;
        }
    }
}
