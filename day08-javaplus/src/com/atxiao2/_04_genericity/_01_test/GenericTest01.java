package com.atxiao2._04_genericity._01_test;

import org.junit.Test;

import java.util.*;

/**
 * @author : XiaoEr
 * @date : 2022/9/2
 *
 * 泛型 （jdk5.0增加）
 *    在集接口中使用泛型：
 *          1.集合接口或者集合类在jdk5.0都修改为带泛型的结构
 *          2.在实例化集合类时，可以指明具体的泛型类型,
 *            指明完以后集合类或接口中凡是定义类或接口时内部结构中使用到类的泛型的位置都指定为实例化时指明的泛型类型
 *    泛型类型必须是类，不能是基本数据类型，需要用得到基本数据类型时，则使用对应的包装类
 *    如果实例化时，没有指明泛型的类型，则默认类型的java.lang.Object类型
 *
 *  自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 *  泛型方法：在方法中出翔了泛型结构，泛型参数与类的泛型参数没有任何关系
 *
 */
public class GenericTest01 {

    /**
     * 泛型在集合中的使用 ArrayList为例
     */
    @Test
    public void test01(){
        //使用泛型可以解决存放类型不安全的问题
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        // integers.add(“a”);

        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            //避免类型强转问题
            Integer next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    /**
     * 以HashMap为例
     */
    @Test
    public void test02(){
        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        // map.put(3,"c");
        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            Integer value = next.getValue();
            String key = next.getKey();
            System.out.println(key + "-->" + value);
        }
    }

    /**
     * 泛型方法
     */
    @Test
    public void test03(){
        Integer[] arr = new Integer[10];
        arr[1] = 2;
        //泛型方法在调用时指明泛型类型
        List<Integer> integers = copyListToArray(arr);

    }

    public static <E> List<E> copyListToArray(E[] e){
        List<E> es = Arrays.asList(e);
        return es;
    }
}
