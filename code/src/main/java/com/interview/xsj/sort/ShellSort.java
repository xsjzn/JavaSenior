package com.interview.xsj.sort;

/**
 * @author xsj
 * @create 2021-03-12 19:25
 */
public class ShellSort {
    public static int[] shellSort(int[] array){
        int len=array.length;
        if(len==0){
            return array;
        }
        int current,gap=len/2;
        while (gap>2){
            for(int i=gap;i<len;i++){
                current=array[i];
                int preIndex=i-gap;
                while(preIndex>=0&&array[preIndex]>current){
                    array[preIndex+gap]=array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=current;
            }
            gap/=2;
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
