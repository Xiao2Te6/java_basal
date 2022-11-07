package com.atxiao2._05_io_stream._02_io_test._06_object_stream_test;


import java.io.Serializable;

/**
 * @author : XiaoEr
 * @date : 2022/10/4
 */
public class Person implements Serializable {

    private String name;
    //被transient和static修饰的属性不能被序列化
    // private transient int age;
    private int age;

    private Account account;//类中的属性也需要可序列化

    public Person() {
    }

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }
}
class Account implements Serializable{
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "account{" +
                "balance=" + balance +
                '}';
    }
}

