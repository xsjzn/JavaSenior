package com.interview.xsj.priorityqueue;

/**
 * @author xsj
 * @create 2021-07-26 9:08
 */
//extends泛型上限  也就是
//public class MaxPQ<Key extends Comparable<Key>> {
//    //存储元素的数组
//    private Key[] pq;
//    // 当前 Priority Queue 中的元素个数
//    private int N=0;
//
//    public MaxPQ(int cap){
//        // 索引 0 不用，所以多分配一个空间
//        pq=(Key[])new Comparable[cap+1];
//    }
//    /* 返回当前队列中最大元素 */
//    public Key max(){
//        return pq[1];
//    }
//    /* 插入元素 e */
//    public void insert(Key e) {
//        N++;
//        pq[N]=e;
//        swim(N);
//    }
//
//    /* 删除并返回当前队列中最大元素 */
//    public Key delMax() {
//        Key max=pq[1];
//        exch(1,N);
//        pq[N]=null;
//        N--;
//        // 让 pq[1] 下沉到正确位置
//        sink(1);
//        return max;
//    }
//
//    /* 上浮第 k 个元素，以维护最大堆性质 */
//    private void swim(int k){
//        //k来到堆顶就不继续上浮 否则只要其父节点比当前结点小 就交换两者
//        while(k>1&&less(parent(k),k)){
//            exch(parent(k),k);
//            //交换完之后 继续判断是否需要继续上浮交换
//            k=parent(k);
//        }
//    }
//
//    /* 下沉第 k 个元素，以维护最大堆性质 */
//    private void sink(int k) {
//
//        while(left(k)<=N){
//            int child=left(k);
//            if(right(k)<=N&&less(child,right(k))){
//                child=right(k);
//            }
//            //结点 k 比俩孩子都大，就不必下沉了
//            if(less(child,k)) break;
//            exch(child,k);
//            k=child;
//        }
//    }
//
//    /* 交换数组的两个元素 */
//    private void exch(int i, int j) {
//        Key temp=pq[i];
//        pq[i]=pq[j];
//        pq[j]=temp;
//    }
//    /* pq[i] 是否比 pq[j] 小？ */
//    private boolean less(int i,int j){
//        return pq[i].compareTo(pq[j])<0;
//    }
//    private int parent(int root){
//        return root/2;
//    }
//
//    private int left(int root){
//        return 2*root;
//    }
//
//    private int right(int root){
//        return 2*root+1;
//    }
//
//    //大顶堆
//    public static void main(String[] args) {
//        MaxPQ<Integer> maxPQ = new MaxPQ<>(5);
//        for(int i=0;i<5;i++){
//            maxPQ.insert(i);
//        }
//        System.out.println(maxPQ.max());
//        System.out.println(maxPQ.delMax());
//        System.out.println(maxPQ.max());
//    }
//
//
//}
public class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N=0;
    //下标0不存
    public MaxPQ(int cap){
        pq=(Key[])new Comparable[cap+1];
    }
    //返回当前最大元素
    public Key getMax(){
        return pq[1];
    }
    public int parent(int root){
        return root/2;
    }
    public int leftChild(int root){
        return root*2;
    }
    public int rightChild(int root){
        return root*2+1;
    }
    //上浮 不断比较和父节点的大小
    public void swim(int k){
        while(k>1&&less(parent(k),k)){
            swap(parent(k),k);
            k=parent(k);//下标来到父节点
        }
    }

    //下沉 从当前结点开始一直找比它小的孩子结点
    public void sink(int k){
        while(leftChild(k)<N){
            int child=leftChild(k);
            if(rightChild(k)<N&&less(child,rightChild(k))){
                child=rightChild(k);
            }
            if(less(child,k)){
                break;
            }
            swap(child,k);
            k=child;
        }
    }

    private void swap(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    //插入元素 先插入到堆的最后一个位置 再上浮到合理位置
    public void insert(Key e){
        N++;
        pq[N]=e;
        swim(N);
    }
    //删除最大值 只需要拿到堆顶元素即可 将其和最后一个元素交换后 删掉最后一个元素 再将新的堆顶进行下沉
    public Key deleteMax(){
        Key max=pq[1];
        swap(1,N);
        N--;
        sink(1);
        return max;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(5);
        for(int i=0;i<5;i++){
            maxPQ.insert(i);
        }
        System.out.println(maxPQ.getMax());
        System.out.println(maxPQ.deleteMax());
        System.out.println(maxPQ.getMax());
    }


}