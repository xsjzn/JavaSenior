package com.interview.xsj.sort;

import java.util.Arrays;

/**
 * @author xsj
 * @create 2021-03-12 18:50
 */
public class MergeSort {
    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if(array.length<2){
            return array;
        }
        int mid=array.length/2;
        int[] left= Arrays.copyOfRange(array,0,mid);
        int[] right= Arrays.copyOfRange(array,mid,array.length);
        return merge(MergeSort(left),MergeSort(right));

    }

    /**
     * 归并排序——将两段有序数组结合成一个有序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result=new int[left.length+right.length];
        int i=0,j=0,k=0;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                result[k++]=left[i++];
            }else{
                result[k++]=right[j++];
            }
        }
        while (i<left.length){
           result[k++]=left[i++];
        }
        while(j<right.length){
            result[k++]=right[j++];
        }


        return  result;

















//        int[] result=new int[left.length+right.length];
//        int i=0,j=0,k=0;
//        while(i<left.length&&j<right.length){
//            if(left[i]<=right[j]) {
//                result[k++] = left[i++];
//            }else {
//                result[k++] = right[j++];
//            }
//        }
//        while(i<left.length){
//            result[k++]=left[i++];
//        }
//        while(j<right.length){
//            result[k++]=right[j++];
//        }
//        return result;
    }

    public static void main(String[] args) {
        int[] res={1,0,3,2,232,12,26};
        int[] ints = MergeSort(res);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
