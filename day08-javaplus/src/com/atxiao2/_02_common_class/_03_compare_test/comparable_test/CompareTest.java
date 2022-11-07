package com.atxiao2._02_common_class._03_compare_test.comparable_test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对象之间的比较需要用到 ComParable 和 Comparator 接口
 *      String 和包装类等 已经实现了 ComParable接口，可以调用compareTo（）方法进行大小比较
 *      一般自定义类会实现Comparable接口，重写compareTo（）方法，便于排序方法调用
 */
public class CompareTest {

    @Test
    public void test01(){
        String[] strs = {"aa","dd","vv","bb","hh","tt","yy","ff","qq"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
    }

    /**
     * ComParable 接口的使用
     * //自然排序使用
     * String 和包装类等 已经实现了 ComParable接口，可以调用compareTo（）方法进行大小比较
     *
     *    一般自定义类会实现Comparable接口，重写compareTo（）方法，便于排序方法调用
     *
     *         */
    @Test
    public void test02(){
        Goods[] goods = new Goods[]{new Goods("a",10.0),
                                    new Goods("b",55.0),
                                    new Goods("c",2.0),
                                    new Goods("d",6.0)};
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }


    /**
     * Comparator 接口使用
     *  //定制排序使用
     *  当元素类没用实现comparable接口而又不方便修改代码时候，或者实现了comparable接口的排序规则不适合当前操作
     *  就可以考虑用comparator的对象来排序
     *
     *  使用comparator接口需要重写compare（object o1,object o2）方法,
     *  比较两个参数如果返回式正数则o1大 返回0相等 返回负数o2大
     */
    @Test
    public void test03(){
        String[] strs = {"aa","dd","vv","bb","hh","tt","yy","ff","qq"};
        Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                //按照字符串的从大到小排
                return -o1.compareTo(o2);
            }
        });
    }


    @Test
    public void test04(){
        Goods[] goods = new Goods[]{new Goods("a",10.0),
                                    new Goods("c",55.0),
                                    new Goods("c",2.0),
                                    new Goods("d",6.0)};
        Arrays.sort(goods,new Comparator<Goods>(){
            //一样的按照商品名从大到小排,再按照商品价格从大到小排，
            @Override
            public int compare(Goods g1, Goods g2) {
                if(g1.getName().equals(g2.getName())){
                    return -Double.compare(g1.getPrice(),g2.getPrice());
                }else {
                    return -g1.getName().compareTo(g2.getName());
                }
            }
        });

        System.out.println(Arrays.toString(goods));
    }
}
