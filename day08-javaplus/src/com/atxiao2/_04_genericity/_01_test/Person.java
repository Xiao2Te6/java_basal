package com.atxiao2._04_genericity._01_test;

/**
 * @author : XiaoEr
 * @date : 2022/9/2
 *
 * 自定义泛型类
 */
public class Person<T> {
    private String name;
    private  T score;
    //静态结构中不能使用泛型（泛型在对象实例化时使用的）
    // private static  T s;

    public Person() {
    }

    public Person(String name, T t) {
        this.name = name;
        this.score = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GenericTest02{" +
                "name='" + name + '\'' +
                ", t=" + score +
                '}';
    }
}
