package com.atxiao2._01_multi_thread.test.thread_test;

/**
 * 多线程创建方式一：继承于Thread类
 *
 * ex:遍历100以内的偶数
 *
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //4.创建Thread子类的对象
        MyThread myThread = new MyThread();

        //5.通过对象调用start（）方法:
                //(1)启动当前线程
                //(2)调用当前线程的run（）方法
        myThread.start();
            //我们不能直接调用run（）方法起启动线程。
            //不可以让已经start（）启动的线程再启动(报错IllegalThreadStateException)

        //在创建一个对象启动一个线程
        MyThread myThread1 = new MyThread();
        myThread1.start();

        for (int i = 0; i < 500; i++){
            System.out.println(Thread.currentThread().getName() + " : hello");
        }
    }
}


//1.创建一个继承Thread的子类
class MyThread extends Thread{

    //2.重写Thread的run（）方法
    @Override
    public void run() {
        //3.将需要多线程运行的代码写在run方法内
        for (int i = 0; i < 200; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }

    }
}