package com.interview.xsj.priorityqueue;

/**
 * @author xsj
 * @create 2021-07-13 11:31
 */
//public class MyPriorityQueue<AnyType> {
//    private static final int DEFAULT_INIT_CAPACITY=11;
//    private Object[] queue;//存储优先队列的元素
//
//    private int size;//堆中当前元素的数量
//    private Comparator<? super AnyType> comparator;//比较器
//    /************构造函数****************/
//    //无参构造函数
//    MyPriorityQueue(){
//        this(DEFAULT_INIT_CAPACITY,null);
//    }
//    //Collection集合参数
//    MyPriorityQueue(Collection<? extends AnyType> c){
//
//    }
//    //带比较器和初始化容量的构造参数
//    MyPriorityQueue(int num,Comparator<?super AnyType> comparator){
//        if(num<1){
//            throw new IllegalArgumentException("初始化容量不能小于1");
//        }
//        this.queue=new Object[num];
//        this.comparator=comparator;
//    }
//
//
//    public boolean add(AnyType e){
//        if(e==null){
//            throw new NullPointerException("元素不能为空");
//        }
//        int i=size;
//        if(i>=queue.length){
//            //扩容
//            grow(i+1);
//        }
//        size++;
//        if(i==0){
//            queue[0]=e;
//        }else{
//            siftUp(i,e);
//        }
//        return true;
//    }
//    //将结点i向上调整
//    private void siftUp(int i, AnyType e) {
//        if(comparator==null){
//            siftUpComparable(i,e);
//        }else{
//            siftUpUsingComparator(i,e);
//        }
//    }
//    //使用指定的比较器
//    private void siftUpUsingComparator(int i, AnyType e) {
//
//    }
//
//    /**
//     * 不使用指定比较器
//     *  向上调整结点k使其满足最小堆
//     *  冒泡排序
//     *  只要比父节点小就继续向上调整到父节点的位置
//     * @param k 待调整的结点下标
//     * @param x 类型结点的值
//     */
//    private void siftUpComparable(int k, AnyType x) {
//        Comparable<?super AnyType> key=(Comparable<?super AnyType>)x;
//        while(k>0){
//            int parent=(k-1)>>>1;//父节点位置
//            Object e=queue[parent];
//            if(key.compareTo((AnyType) e)>=0){
//                break;
//            }
//            queue[k]=queue[parent];
//            k=parent;
//        }
//        queue[k]=key;
//    }
//
//    private void grow(int minCapacity) {
//        int oldCapcity=queue.length;
//        int newCapacity=oldCapcity+((oldCapcity<64)?oldCapcity+2:(oldCapcity>>1));
//        queue= Arrays.copyOf(queue,newCapacity);//数组拷贝
//    }
//
//    /**
//     *
//     * @return 返回堆顶元素
//     */
//    public AnyType peek(){
//        return (size==0)?null:(AnyType)queue[0];
//    }
//
//    /**
//     *
//     * @return 出列最小元素 并删除
//     */
//    public AnyType poll(){
//        if(size==0){
//            return null;
//        }
//        int tail=--size;
//        AnyType result=(AnyType) queue[0];//返回结果
//        //该元素是需要调整的
//        AnyType x=(AnyType)queue[tail];
//        queue[tail]=null;
//        if(tail!=0){
//            siftDown(0,x);
//        }
//        return result;
//    }
//    //向下调整
//    private void siftDown(int k, AnyType x) {
//        if (comparator != null)
//            siftDownUsingComparator(k, x);
//        else
//            siftDownComparable(k, x);
//    }
//
//    private void siftDownComparable(int k, AnyType x) {
//        Comparable<? super AnyType> key=(Comparable<? super AnyType>)x;
//        int half=size>>>1;//最后一个非叶子结点
//        while(k<half){
//            int child=(k<<1)+1;
//            int right=child+1;
//            Object temp=queue[child];
//            //寻找最小的
//            if(right<size&&((Comparable<?super AnyType>)child).compareTo((AnyType)queue[right])>0){
//                temp=queue[child=right];
//            }
//            if(key.compareTo((AnyType)temp)<0){
//                break;//待调整结点小于叶子结点停止调整
//            }
//            //孩子结点上移
//            queue[k]=temp;
//            //k继续往下走
//            k=child;
//        }
//        queue[k]=key;
//
//    }
//
//    private void siftDownUsingComparator(int k, AnyType x) {
//
//    }
//    public int size(){
//        return size;
//    }
//
//
//}
