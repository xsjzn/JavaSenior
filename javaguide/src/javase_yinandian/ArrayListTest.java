package javase_yinandian;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xsj
 * @create 2020-10-08 21:11
 */
public class ArrayListTest {
    @Test
    public void Test1(){
        String[] strs = {"you", "wu"};
        List<String> list = Arrays.asList(strs);
        list.add("123");
        System.out.println(list);//.UnsupportedOperationException
    }
    //Arrays.asList() 方法返回的并不是 java.util.ArrayList
    // ，而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
    @Test
    public void Test2(){
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值 [I@51c8530f
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
    }
//    当传入一个原生数据类型数组时，Arrays.asList() 的真正得到的参数就不是数组中的元素
//    ，而是数组对象本身！此时List 的唯一元素就是这个数组，这也就解释了上面的代码。

//    我们使用包装类型数组就可以解决这个问题。
@Test
public void Test3(){
    Integer[] myArray = {1, 2, 3};
    List myList = Arrays.asList(myArray);
    System.out.println(myList.size());//3
    System.out.println(myList.get(0));//1
    System.out.println(myList.get(1));//2
//    int[] array = (int[]) myList.get(0);

}
//如何正确的将数组转换为ArrayList?
    @Test
    public void Test4(){
        // 最简便的方法(推荐)
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a","b","c"));
//        3. 使用 Java8 的Stream(推荐)
        Integer[] myArray={1,2,3};
        List<Integer> list1 = Arrays.stream(myArray).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        List<Integer> list2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
//        4. 使用 Guava(推荐) 需要導入包
        //对于不可变集合，你可以使用ImmutableList类及其of()与copyOf()工厂方法：（参数不能为空）
//        List<String> il = ImmutableList.of("string", "elements");  // from varargs
//        List<String> il = ImmutableList.copyOf(aStringArray);      // from array
//        对于可变集合，你可以使用Lists类及其newArrayList()工厂方法：
//
//        List<String> l1 = Lists.newArrayList(anotherListOrCollection);    // from collection
//        List<String> l2 = Lists.newArrayList(aStringArray);               // from array
//        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from vararg
//        5. 使用 Apache Commons Collections
        List<String> list3 = new ArrayList<String>();
//        CollectionUtils.addAll(list, str);
//        6. 使用 Java9 的 List.of()方法
            Integer[] array={1,2,3};
//        List<Integer> list4 = List.of(array);
        System.out.println(list);
    }


}
