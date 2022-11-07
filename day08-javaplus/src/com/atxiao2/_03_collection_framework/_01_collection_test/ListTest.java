package com.atxiao2._03_collection_framework._01_collection_test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author : XiaoEr
 * @date : 2022/8/6
 *
 *
 * |----Collection接口：单序列集合，用来存储一个一个的对象
 *    |----List接口：存储有序的、可重复的数据（“动态”数组）
 *        |----ArrayList （List接口的主要实现类） 效率高，线程不安全，便于查询和修改，底层使用Object[] elementData存储
 *        |----LinkList 便于增加和删除，底层使用双向链表存储
 *        |----vector  （list接口的古老实现类 jdk1.0出现） 效率低，但线程安全，底层使用Object[] elementData存储（不怎么用了，扩容默认两倍）
 *
 * List接口  存储有序的、可重复的数据（“动态”数组）
 *       ArrayList:
 *                  底层创建数组的方式在jdk7之前有所不同
 *                      JDK7之前 创建ArrayList对象时会在底层创建一个长度为10的 Object[10] elementData数组去存放
 *                      JDk8之后 创建ArrayList对象时底层的 Object[] elementData 初始化为{},并没有创建长度，
 *                          在第一次使用add() 才初始化长度为10，如果add的元素超过10个，就用添加元素长度初始化（懒加载，延迟数组创建，节省内存 ）
 *
 *                  ArrayList 在每次add前都判断底层数组容量，如果此次add将导致数组容量不够，将会自动扩容（默认为1.5倍）  
 *
 *      LinkedList：双向链表原理为底层的内部定义的 Node 内部类，里面定义三个属性，分别为 prev elem next
 *
 *  常用方法
 *      增：add()
 *      删：remove(int index)
 *      改：set(int index, Object element)
 *      查：get(int index)
 *      插：add(int index, Object element)
 *      长度：size()
 *      遍历： iterator迭代器、循环遍历
 **/
public class ListTest {
    public static void main(String[] args) {
        List list = new List() {

            //--------list子类  常用方法--------------

            /**
             * 添加
             * @param o 需要添加的元素
             * @return 是否添加成功
             */
            @Override
            public boolean add(Object o) {
                return false;
            }

            /**
             * 在指定位置添加（插入）
             * @param index 需要添加的位置
             * @param element 需要添加的元素
             */
            @Override
            public void add(int index, Object element) {

            }

            /**
             * 将集合中的元素全部添加到当前List中
             * @param c
             * @return
             */
            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            /**
             * 将集合中的元素全部添加到当前list指定位置
             * @param index 需要开始插入的索引位置
             * @param c
             * @return
             */
            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            /**
             * 移除指定位置元素
             * @param index 需要移除元素的索引
             * @return 返回删除位置的元素
             */
            @Override
            public Object remove(int index) {
                return null;
            }

            /**
             * 移除当前List中的指定对象
             * @param o 需要移除的对象
             * @return
             */
            @Override
            public boolean remove(Object o) {
                return false;
            }

            /**
             * 获取指定对象首次出现的索引
             * @param o 需要获取索引的对象
             * @return
             */
            @Override
            public int indexOf(Object o) {
                return 0;
            }

            /**
             *  获取指定对象末次出现的索引
             * @param o
             * @return
             */
            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            /**
             * 获取指定索引位置的元素
             * @param index 需要获取的元素的索引
             * @return 传入索引对应的对象
             */
            @Override
            public Object get(int index) {
                return null;
            }

            /**
             * 修改指定索引位置的元素
             * @param index
             * @param element
             * @return
             */
            @Override
            public Object set(int index, Object element) {
                return null;
            }
            /**
             * 获取指定索引区间中的元素
             * @param fromIndex 开始的索引
             * @param toIndex 结束的索引
             * @return 截取的子List [fromIndex，toIndex)
             */
            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }

            // --------------------------- collection接口方法----------------------

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public void clear() {

            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }
        };
    }
}
