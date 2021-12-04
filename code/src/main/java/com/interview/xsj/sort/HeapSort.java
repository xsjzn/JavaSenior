package com.interview.xsj.sort;

/**
 * @author xsj
 * @create 2021-03-12 19:57
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int length=arr.length;
        //1.构建大顶堆
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr, i, arr.length);
//        }
        //2.调整堆结构+交换堆顶元素与末尾元素
//        for (int j = arr.length - 1; j > 0; j--) {
//            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
//            adjustHeap(arr, 0, j);//重新对堆进行调整
//        }



        //构建大顶堆 从第一个非叶子结点开始
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,length);
        }
        //2.调整堆结构 +交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//交换堆顶元素和末尾元素,此时最后一个元素已经来到了 它应该在的位置上了

            adjustHeap(arr,0,j);//重新对堆进行排序
        }
    }
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i  调整的起始位置
     * @param length 调整的结束位置
     */
//    public static void adjustHeap(int[] arr, int i,int length) {
//        int tmp=arr[i];
//        for(int k=2*i+1;k<length;k=k*2+1){//k会继续向叶子结点走
//            //找到最大的叶节点
//            if(k+1<length&&arr[k]<arr[k+1]){
//                k++;
//            }
//            if(arr[k]>tmp){
//                //让叶子结点放到根节点的位置上
//                arr[i]=arr[k];
//
//            }else{
//                break;
//            }
//        }
//    }
    public static void adjustHeap(int[] arr, int i,int length) {
        int tmp=arr[i];
        for(int k=2*i+1;k<length;k=k*2+1){
            //找到最大的叶节点
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>tmp){//如果子节点大于父节点 将子节点的值赋予父节点 不用交换
                arr[i]=arr[k];
                i=k;//让 i来到原来子节点的位置继续比较 看看是不是比子节点的子节点还小
            }else {
                break;
            }
        }
        arr[i]=tmp;//将temp值放到最终的位置


    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] nums={1,0,3,2,232,12,26};
        sort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
