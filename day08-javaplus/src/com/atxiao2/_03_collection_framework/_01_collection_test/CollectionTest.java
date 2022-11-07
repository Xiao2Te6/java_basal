package com.atxiao2._03_collection_framework._01_collection_test;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author : XiaoEr
 * @date : 2022/8/5
 *
 *  集合框架
 *        集合、数组都是对多个数据进行存储操作的结构，简称java容器
 *              （此时的存储主要内存方面，不涉及到持久层（.txt, .jpg, .avi, 数据库））
 *
 *
 *  框架组成
 *       |----Collection接口：单序列集合，用来存储一个一个的对象
 *          |----List接口：存储有有序的可重复的数据（“动态”数组）
 *              |----ArrayList （List接口的主要实现类） 效率高，线程不安全，便于查询和修改，底层使用Object[]存储
 *              |----LinkedList 便于增加和删除，底层使用双向链表存储
 *              |----vector  （list接口的古老实现类 jdk1.0出现） 效率低，但线程安全，底层使用Object[]存储
 *
 *          |----Set接口：存储无序的、不可重复的数据 （数学里的集合）
 *              |----HashSet 作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                  |----LinkHashSet 作为hHashSet的之类，在遍历内部数据时，可以按照添加的顺序遍历（看似有序的）
 *              |----TreeSet 可以按照添加的对象的指定属性进行排序（底层为红黑树）
 *
 *      |----Map接口：双列集合，用来存储一对、一对（key,vale）的数据  (高中函数 y = f(x), key是对value的一个映射，  key只有一个)
 *              |----HashMap 作为map的主要实现类，线程不安全的，效率高，可以存储key或value为null的值
 *                  |----LinkedHashMap 在HashMap上添加了双向链表（元素前后添加了一对引用），
 *                                     在遍历map元素时，可以按照添加的顺序遍历，在频繁遍历时，LinkedHashMap的执行效率高于HashMap
 *              |----TreeMap 保证按照key-value键值对进行排序，实现排序遍历，
 *                           此时考虑key 的定制排序或自然排序，底层使用红黑树（排序二叉树中的一种特殊结构）
 *              |----Hashtable 作为Map接口的古老实现类（JDk1.0），线程安全，效率低，不可以存储key或value为null的值（会报空指针异常）
 *                  |----Properties 常用来处理配置文件，key和value都是String类型
 *
 *
 *
 *  Collection 接口 中常用方法使用
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection myCollection = new Collection() {

            /**
             * 返回集合元素个数
             * @return 集合元素个数
             */
            @Override
            public int size() {
                return 0;
            }

            /**
             * 判断是否为空
             * @return 空返回true ，非空返回false
             */
            @Override
            public boolean isEmpty() {
                return false;
            }



            /**
             * 判断集合内是否包含该对象
             * @param o 需要判断的对象
             * @return  包含返回true，不包含返回true
             * 通过equals（）方法一个一个的比较，比较的是内容，如果该对象没有重写equals方法者，将会比较对象地址值
             */
            @Override
            public boolean contains(Object o) {
                return false;
            }

            /**
             * 返回一个该集合的迭代器对象
             * @return 该集合的迭代器对象
             *
             * 迭代器定义：提供一种方法去访问一个容器对象中的各个元素，而又不暴露该对象的细节（迭代器模式就是为容器而生的）
             *   迭代器常用方法：
             *         hasNext（）：判断当前集合是否含有下一个元素
             *         next（）：指针指向下一个元素并返回该元素
             */
            @Override
            public Iterator iterator() {
                return null;
            }

            /**
             * 将该集合转换为数组
             * @return 转换过后的数组
             */
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            /**
             * 在集合中增加单个元素
             * @param o 需要添加的对象
             * @return 添加是否成功
             */
            @Override
            public boolean add(Object o) {
                return false;
            }

            /**
             * 删除集合中的单个元素（通过equals比较找到然后删除）
             * @param o 需要删除的元素
             * @return  是否删除成功
             */
            @Override
            public boolean remove(Object o) {
                return false;
            }

            /**
             * 向该集合中增加 传入集合中的所有元素
             * @param c 需要增加的元素的集合
             * @return 是否增加成功
             */
            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            /**
             * 清除集合中的所有元素
             */
            @Override
            public void clear() {

            }

            /**
             * 保留当前集合和传入集合中相同的元素（交集）
             * @param c 需要相交的集合
             * @return 是否成功
             */
            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            /**
             * 从当前集合中 删除所有传入集合中的元素，传入集合中有的元素（差集，去两个除相同的部分）
             * @param c 需要删除的元素的集合
             * @return 是否删除成功
             */
            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            /**
             * 判断传入集合元素，是否全部包含在当前集合中
             * @param c
             * @return
             */
            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            /**
             * 将当前集合转换为指定类型数组
             * @param a 需要指定类的对应类型数组
             * @return
             */
            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            //数组 --> 集合 通过Arrays.asList() 静态方法转换,如果传入的是一个基本数据类型数组，会将该数组当作一个集合的一个元素
        };
    }
}
