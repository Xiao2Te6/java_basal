package com.atxiao2._01_multi_thread.exercise.product_test;

public class productTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Customer c1 = new Customer(clerk);
        Producer p1 = new Producer(clerk);

        c1.setName("顾客");
        p1.setName("厂家");

        c1.start();
        p1.start();
    }
}
