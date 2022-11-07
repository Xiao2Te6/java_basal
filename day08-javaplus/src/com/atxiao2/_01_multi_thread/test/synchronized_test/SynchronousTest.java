package com.atxiao2._01_multi_thread.test.synchronized_test;

/**
 * 同步机制
 * 方式以一：同步代码块
 * <p>
 * synchronized（同步监视器）{
 * //需要被同步的代码（操作共享数据的代码，
 * 共享数据的代码即是多个线程共同操作的属性）
 * }
 * 同步监视器:俗称”锁“，任何一个对象都能充当锁，多个线程必须要共用同一把锁
 * 劣势：当synchronized内的代码一次只能通过一个线程，效率低
 * <p>
 * 方式二：同步方法
 */
public class SynchronousTest {
    public static void main(String[] args) {
//        //用runnable实现多线程
//        Window2 w = new Window2();
//        Thread t1 = new Thread(w);
//        Thread t2 = new Thread(w);
//        Thread t3 = new Thread(w);
//
//        t1.setName("窗口一 ：");
//        t2.setName("窗口二 ：");
//        t3.setName("窗口三 ：");
//
//        t1.start();
//        t2.start();
//        t3.start();

        //用继承Thread类的方式实现
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口一 ：");
        w2.setName("窗口二 ：");
        w3.setName("窗口三 ：");

        w1.start();
        w2.start();
        w3.start();

    }
}

/**
 * 买票小测试，三个窗口同时卖票:勇实现Runnable方法
 * （线程不安全 出现重票）
 */
class Window2 implements Runnable {
    private int ticket = 100;
    //同步监视器（方式一）
    Object obj = new Object();
    @Override
    public void run() {
        //Object obj = new Object();   锁不唯一
        for (; ; ) {
            //synchronized (obj) { 方式一
            synchronized (this) {   //方式二使用当前对象
                if (ticket > 0) {

                    //出现线程安全问题（出现错票）
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "还有" + ticket + "票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

/**
 *买票小测试，三个窗口同时卖票:用继承Thread方法
 * （线程不安全）
 */
class Window extends Thread {
    private static int ticket = 100;
    //同步监视器(由于启动多个线程需要创建多个对象，如果不是静态就会锁不唯一) 方式一
//    static Object obj = new Object();
    @Override
    public void run() {
                //synchronized (this) { 错误方式，因为启动线程会创建多个对象
                //synchronized (obj) {
        synchronized(Window.class){     //方式二，类也是对象 Class class1 = Window.class
            for (; ; ) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(getName() + "还有" + ticket + "票");
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }
}
