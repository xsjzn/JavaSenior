package com.interview.xsj.mianshi.tc0406;

/**
 * @author xsj
 * @create 2021-04-06 18:41
 */

public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        int[] test={1,2,56,34,0};
        sort(test);
//        Collections.reverse(res);

//        for (int i : test) {
//            System.out.print(i+" ");
//        }
    }

    private static void sort(int[] list){
        //建堆
        int len=list.length;
        for(int i=len/2-1;i>=0;i--){
            heapSort(list,i,list.length);
        }

        //排序 调整堆结构+交换堆顶元素与末尾元素
        for(int i=len-1;i>0;i--){
            swap(i,0,list);
            //调整
            heapSort(list,0,i);
        }
        for (int i=0;i<len;i++){
            System.out.print(list[i]+" ");
        }
    }

    private static void swap(int a, int b,int[] list) {
        int tmp=list[a];
        list[a]=list[b];
        list[b]=tmp;
    }

    /**
     * 从list[st] 到list[high]范围内调整
     * @param list
     * @param st
     * @param high  也很重要
     */
    private static void heapSort(int[] list, int st,int high) {
        //根节点
        int tmp=list[st];
        for(int k=st*2+1;k<high;k=2*k+1){
            //选出最小的叶节点
            if(k+1<high&&list[k+1]<list[k]){
                k++;
            }
            if(list[k]<tmp){//叶节点小于根节点
                //叶节点放到根节点位置上
               list[st]=list[k];
               st=k;// 让st来到原来的子节点继续比较
            }else{
                break;
            }
        }
        list[st]=tmp;
    }
}
