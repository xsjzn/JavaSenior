package com.interview.xsj.sort;

/**
 * @author xsj
 * @create 2021-03-12 17:01
 */
public class QuickSort {
    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if(left>right){
            return ;
        }
        int i=left,j=right;
        int tmp=arr[left];
        while(i<j){
            while(arr[j]>=tmp) j--;
            arr[i]=arr[j];
            while(arr[i]<=tmp) i++;
            arr[j]=arr[i];
        }
        arr[i]=tmp;
        quickSort(arr,left,i);
        quickSort(arr,i+1,right);


















//        if(left>right){
//            return;
//        }
//        int tmp=arr[left];
//        int i=left,j=right;
//        while(i<j){
//            while(i<j&&arr[j]>=tmp) j--;
//            arr[i]=arr[j];
//
//            while(i<j&&arr[i]<=tmp) i++;
//            arr[j]=arr[i];
//        }
//        arr[i]=tmp;
//        quickSort(arr,left,i-1);
//        quickSort(arr,i+1,right);

    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void main(String[] args) {
        int[] nums={1,0,3,2,232,12,26};
//        bubbleSort(nums);
        quickSort(nums,0,nums.length-1);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
}
