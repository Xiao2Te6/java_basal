package com.atxiao2._07_reflection._04_get_class_stracture.person;

import java.io.Serializable;

/**
 * @author : XiaoEr
 * @date : 2022/10/31
 */
public class Animal<T> implements Serializable {

    public int height;
    private double weight;

    public void eat(){
        System.out.println("吃");
    }
    private int walk(){
        System.out.println("走");
        return 0;
    }
}
