package com.atxiao2._01_multi_thread.test.thread_test;

/**
 * 多线程创建方式二：实现Runnable接口
 *   1.创建一个实现了Runnable接口的实现类
 *   2.用该类去实现Runnable接口中的run（）方法
 *   3.创建该类的对象
 *   4.将此对象作为参数传到Thread类的构造器中，创建Thread对象
 *   5.用创建的Thread对象调用start（）方法
 *
 * 开发中优先选择实现Runnable接口的方式去 使用多线程
 *      原因：1.该方式没有类单继承的局限性
 *           2.该方式更适合多个线程共享数据的情况
 * 因为Thread方法也实现了Runnable接口，所以两种方式都需要复习run（）方法
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建该类的对象
        MyThread4 myThread4 = new MyThread4();
        //4.将此对象作为参数传到Thread类的构造器中，创建Thread对象
        Thread p = new Thread(myThread4);
        //5.用创建的Thread对象调用start（）方法
        p.start();

        //再启动一个线程便利100以内的偶数
        Thread p1 = new Thread(myThread4);
        p1.start();
    }
}

//1.创建一个实现了Runnable接口的实现类
class MyThread4 implements Runnable{
    //2.用该类去实现Runnable接口中的run（）方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
