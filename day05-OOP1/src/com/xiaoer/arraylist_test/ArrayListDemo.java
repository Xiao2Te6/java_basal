package com.xiaoer.arraylist_test;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("apple");
        list.add("pear");
        list.add("banana");
        System.out.println(list);
        list.remove("pear");
        System.out.println(list);
        list.set(0,"Apple");
        System.out.println(list.get(0));
    }
}
