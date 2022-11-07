package com.xiaoer.hash_test;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo
{
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        // 增
        set.add("apple");
        set.add("orange");
        set.add("banana");
        set.add("banana");
        set.add("banana");
        //无需且唯一
        System.out.println(set);
        // 删
        set.remove("banana");
        // 改(查到了删除在加新的)
        // 查
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
