package com.interview.xsj.mianshi.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 */
public class fruitBagNum {

    public static void main(String[] args) {
//        int[] fruitBagNum = findFruitBagNum(38, 0, 0);
        int[] fruitBagNum= findFruitBagWithDp(26);
        System.out.println(fruitBagNum[0]+":"+fruitBagNum[1]);

    }
    /**
     * 返回填完m的 两种袋子的量 如果填不满 返回 【-1，-1】
     * @param curAppleNum 总的苹果数
     * @param numBagOne 大小为6的袋子数量
     * @param numBagTwo 大小为8的袋子数量
     * @return 两种袋子的总数量
     */
    public static int[] findFruitBagNum(int curAppleNum,int numBagOne,int numBagTwo){
        if(curAppleNum==0){
            return new int[]{numBagOne,numBagTwo};
        }
        int[] useBagOne={-1,-1};
        int[] useBagTwo= {-1,-1};
        if(curAppleNum>=8){
            useBagTwo = findFruitBagNum(curAppleNum-8,numBagOne,numBagTwo+1);
        }
        if(curAppleNum>=6){
            useBagOne= findFruitBagNum(curAppleNum-6,numBagOne+1,numBagTwo);
        }
        //返回 总数最小的
        if(useBagOne[0]!=-1&&useBagTwo[0]!=-1){
            if(useBagOne[0]+useBagOne[1]<=useBagTwo[0]+useBagTwo[1]){
                return useBagOne;
            }
            return useBagTwo;
        }
        if(useBagOne[0]!=-1){
            return useBagOne;
        }
        if(useBagTwo[0]!=-1){
            return useBagTwo;
        }
        return new int[]{-1,-1};
    }


    public static int[] findFruitBagWithDp(int curApple){
        //dp[i][j]表示 容量为i的时候 袋子j的数量 0表示容量为6的袋子 1表示 容量为8的袋子
        int[][] dp=new int[curApple+1][2];
        int[] bags={6,8};
        //初始化
        for(int i=1;i<=curApple;i++){
            Arrays.fill(dp[i],curApple+1);
        }
        for(int i=0;i<=curApple;i++){
            for(int j=0;j<2;j++){
                int weight=bags[j];
                if(i>=weight){
                    //可以装的下
                    int curBagOneNum,curBagTwoNum=curApple+1;
                    if(j==0){
                        curBagOneNum=dp[i-weight][j]+1;
                        curBagTwoNum=dp[i-weight][(j+1)%2];
                    }else{
                        curBagTwoNum=dp[i-weight][j]+1;
                        curBagOneNum=dp[i-weight][(j+1)%2];
                    }
                    //总量更小就更新
                    if(curBagOneNum+curBagTwoNum<dp[i][0]+dp[i][1]){
                        dp[i][0]=curBagOneNum;
                        dp[i][1]=curBagTwoNum;
                    }
                }
            }
        }
        return dp[curApple][0]==curApple+1?new int[]{0,0}:dp[curApple];
    }

}
