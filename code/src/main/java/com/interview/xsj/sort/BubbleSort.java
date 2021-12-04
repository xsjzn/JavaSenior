package com.interview.xsj.sort;

/**
 * @author xsj
 * @create 2021-03-12 16:40
 */
public class BubbleSort {
    /**
     *  1. 区间的元素比较，比较区间内两两之间的元素大小，进行交换
     *  2. 一轮比较下来，最大的元素最大的元素被交换到最后
     *  3. 再比较 n-1 的区间，以此类推。
     *
     * 外层循环表示当前获取第几个最大的数
     * 内层循环表示进行排序的区间
     * @param nums
     */
    public static void bubbleSort(int nums[]){
        int len=nums.length;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }

    }




    public static void main(String[] args) {
        int[] nums={1,0,3,2,232,12,26};
        bubbleSort(nums);
//        quickSort(nums,0,nums.length-1);
//        for (int i : nums) {
//            System.out.print(i+" ");
//        }
    }

}
