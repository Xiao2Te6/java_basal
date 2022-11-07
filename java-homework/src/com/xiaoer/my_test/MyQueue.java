package com.xiaoer.my_test;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<E> {
    private List<E> list =  new ArrayList();

    //获取队列的元素个数、
    public int size(){
        return list.size();
    }
    // 判断队列是否为空、
    public boolean isEmpty(){
        return list.isEmpty();
    }
    // 清空队列、
    public void clear(){
        list.clear();
    }
    // 入队、
    public void enqueue(E e){
        list.add(size(),e);
    }
    // 出队、
    public E dequeue(){
        return list.remove(0);
    }
    // 获取队列的头元素
    public E front(){
        if(isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }
}
