package com.xiaoer.ergodic_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErgodicDemo
{
    public static void main(String[] args) {
         List list = new ArrayList();
         list.add("apple");
         list.add("pear");
         list.add("banana");
        System.out.println(list);

        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }
        System.out.println(list);
    }
}
