package com.atxiao2._03_collection_framework._03_collections_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : XiaoEr
 * @date : 2022/8/13
 *
 * Collections 操作集合的工具类 可以操作Collection和Map
 *
 * 常用方法：
 *      reverse(List) 将list反转
 *      shuffle(List) 对list中的元素进行随机排序（打乱）
 *      sort(List) 对list中的元素进行自然排序
 *      sort(List, Comparator) 对list中的元素进行定制排序
 *      swap(list, int i, int j) 将list中 i 与 j 位置上的元素进行交换
 *
 *      max(Collection) 返回自然排序后 Collection中最右边的值（最大值）
 *      max(Collection, Comparator) 返回定制排序后 Collection中最右边的值（最大值）
 *      min(Collection) 返回自然排序后 Collection中最右边的值（最小值）
 *      min(Collection, Comparator) 返回定制排序后 Collection中最右边的值（最小值）
 *      frequency(Collection, Object) 返回Object在Collection中出现的次数
 *      copy(list dest, List src) 将src中的的内容复制到dest中(将dest中的值修改为src的值 ，dest的size得大于src，否则报错)
 *      replaceAll(List list, Object oldVal, Object newVal) 将list中所有的oldVal值替换成 newVal
 *
 *      Collections类中提供了多个synchronizedXxx()方法，可以将当前集合包装线程同步得集合 如synchronizedList(List)
 */
public class CollectionsTest {

    @Test
    public void test01(){
        List arrList = new ArrayList();
        arrList.add(1);
        arrList.add(7);
        arrList.add(55);
        arrList.add(34);
        arrList.add(34);
        arrList.add(-1);
        arrList.add(43);

        //反转
        Collections.reverse(arrList);
        System.out.println("reverse(arrList)-->" + arrList);

        //打乱
        Collections.shuffle(arrList);
        System.out.println("shuffle(arrList)-->" + arrList);

        //排序
        Collections.sort(arrList);
        System.out.println("sort(arrList)-->" + arrList);

        //交换两个值
        Collections.swap(arrList,0,1);
        System.out.println("swap()-->" + arrList);

        //获取元素出现次数
        System.out.println("frequency()-->" + Collections.frequency(arrList,34));

        //复制 (将新的集合中的值修改为旧的集合的值 ，新集合的size得大于旧得集合，否则报错)
        //方式1
        List newList = new ArrayList();
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        newList.add(1000);
        Collections.copy(newList, arrList);
        System.out.println("newList = " + newList);
        //方式二
        List<Object> newList02 = Arrays.asList(new Object[arrList.size()]);
        Collections.copy(newList02,arrList);
        System.out.println("newList02 = " + newList02);

    }

    /**
     * Collections类中提供了多个synchronizedXxx()方法，可以将当前集合包装线程同步得集合
     */
    @Test
    public void test02() {
        List arrayList = new ArrayList();
        List list = Collections.synchronizedList(arrayList);//就是那同步方法包装list中的各个方法
    }
}
