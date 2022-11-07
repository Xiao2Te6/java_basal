package com.atxiao2._03_collection_framework._01_collection_test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : XiaoEr
 * @date : 2022/8/6
 *
 * 迭代器定义：提供一种方法去访问一个容器对象中的各个元素，而又不暴露该对象的细节（迭代器模式就是为容器而生的）
 *   迭代器常用方法：
 *         hasNext（）：判断当前集合是否含有下一个元素
 *         next（）：指针指向下一个元素并返回该元素
 *
 *  foreach循环，底层就是用的iterator迭代器
 */
public class IteratorTest {

    /**
     * hasNext()
     * next()
     */
    @Test
    public void test01(){

        List list = Arrays.asList(123, 456, "abc", "qwe", false);

        //遍历该集合
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    /**
     * iterator 中remove（）：移除当前迭代器游标指向的集合中的元素
     *      remove（）方法，必须要先要使用next（）将游标指向实际元素，否则报错
     */
    @Test
    public void test02(){
        List list = Arrays.asList(123, 456, "abc", "qwe", false);

        //删除集合中的”abc“元素
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if (next.equals("abc")){
                iterator.remove();
            }
        }

    }

}
