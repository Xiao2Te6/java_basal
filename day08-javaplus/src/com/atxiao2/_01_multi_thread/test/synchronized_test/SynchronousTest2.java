package com.atxiao2._01_multi_thread.test.synchronized_test;

/**
 * 同步机制
 * <p>
 * 方式二：同步方法
 *   如果操作共享数据的代码，完整的声明在一个方法中，就可以将此方法声明为同步的
 *   将该方法用synchronized修饰
 * 同步方法也有同步监视器，只是不需要我们显示声明默认为this，静态的同步监视器默认为当前类本身
 */
public class SynchronousTest2 {
    public static void main(String[] args) {
        //用runnable实现多线程
        Window4 w = new Window4();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一 ：");
        t2.setName("窗口二 ：");
        t3.setName("窗口三 ：");

        t1.start();
        t2.start();
        t3.start();

//        //用继承Thread类的方式实现
//        Window3 w1 = new Window3();
//        Window3 w2 = new Window3();
//        Window3 w3 = new Window3();
//
//        w1.setName("窗口一 ：");
//        w2.setName("窗口二 ：");
//        w3.setName("窗口三 ：");
//
//        w1.start();
//        w2.start();
//        w3.start();

    }
}

/**
 * 买票小测试，三个窗口同时卖票:勇实现Runnable方法
 * （线程不安全 出现重票）
 */
class Window4 implements Runnable {
    private int ticket = 100;
    //同步监视器（方式一）
    Object obj = new Object();

    @Override
    public void run() {
        for (; ; ) {
            show();
            if (ticket <= 0){
                break;
            }
        }
    }
    private synchronized void show(){ //锁默认为this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还有" + ticket + "票");
            ticket--;
        }
    }
}

/**
 * 买票小测试，三个窗口同时卖票:用继承Thread方法
 * （线程不安全）
 */
class Window3 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        for (; ; ) {
            show();
            if (ticket <= 0){
                break;
            }
        }
    }
    private static synchronized void show(){ //当方法为静态时，锁默认为当前类
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还有" + ticket + "票");
            ticket--;
        }
    }
}
