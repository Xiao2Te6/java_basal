package com.xiaoer.my_test;

import org.junit.Test;

public class MyArrayList<E> {
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private E[] elements;

    public MyArrayList(){
        elements = (E[]) new Object[DEFAULT_SIZE];
    }

    //添加、
    public void  add(E element){
        capacity();
        elements[size] = element;
        size++;

    }

    public void add(int index, E element){
        capacity();
        for (int i = size - 1; i > index; i-- ){
            elements[i +1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    // 扩容、
    public void capacity(){
        if(size == elements.length){
            E[] newArr = (E[]) new Object[size * 2];
            for(int i = 0; i < elements.length; i++){
                newArr[i] = elements[i];
            }
            elements = newArr;
        }
    }
    // 删除
    public void remove(int index){
        for(int i = index; i < size; i++){
            elements[i] = elements[i + 1];
        }
        elements[size] = null;
        size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i ++){
            if (i != 0){
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Test
    public void test() {
        MyArrayList<Integer> list = new MyArrayList();
        list.add(111);
        list.add(222);
        list.add(444);
        list.add(444);
        list.add(333);
        list.add(444);
        list.add(444);
        list.add(444);
        list.add(5,333);
        list.remove(5);

        System.out.println(list);
    }
}
