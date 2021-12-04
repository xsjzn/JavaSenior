package com.interview.xsj.sort;

/**
 * @author xsj
 * @create 2021-03-12 19:50
 */
public class SelectSort {

    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i){
                int tmp=arr[i];
                arr[i]=arr[min];
                arr[min]=tmp;
            }
        }








//        for(int i=0;i<arr.length;i++){
//            int min=i;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]<arr[min]){
//                    min=j;
//                }
//            }
//            if(min!=i){
//                int temp=arr[i];
//                arr[i]=arr[min];
//                arr[min]=temp;
//            }
//        }
    }

    public static void main(String[] args) {
        int[] nums={1,0,3,2,232,12,26};
        selectSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
