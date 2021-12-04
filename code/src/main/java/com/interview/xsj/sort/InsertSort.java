package com.interview.xsj.sort;

/**
 * @author xsj
 * @create 2021-03-12 17:27
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        if(arr.length==0){
            return;
        }
        int current=0;
        for(int i=1;i<arr.length;i++){
            current=arr[i];
            int j=i-1;
            //寻找插入位置
            while(j>=0&&current<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            j++;
            arr[j]=current;
        }



















//        if(arr.length==0){
//            return;
//        }
//        int current;
//        for(int i=1;i<arr.length;i++){
//            current=arr[i];
//            int preIndex=i-1;
//            while(preIndex>=0&&current<arr[preIndex]){
//                arr[preIndex+1]=arr[preIndex];
//                preIndex--;
//            }
//            arr[preIndex+1]=current;
//        }

    }
    public static void main(String[] args) {
        int[] nums={1,32,14,2};
//        bubbleSort(nums);
//        quickSort(nums,0,nums.length-1);
        insertSort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
}
