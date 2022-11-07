package com.atxiao2._01_multi_thread.exercise.thread_demo;

/**
 * 练习创建两个分线程，其中一个便利100以内的偶数，另一个遍历100以内的奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        myThread1.start();
//        MyThread2 myThread2 = new MyThread2();
//        myThread2.start();

        //创建Tread类的匿名子类对象
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }

}


//遍历100以内的偶数
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

//便利100以内的奇数
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
