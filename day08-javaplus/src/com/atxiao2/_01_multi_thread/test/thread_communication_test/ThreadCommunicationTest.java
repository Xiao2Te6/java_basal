package com.atxiao2._01_multi_thread.test.thread_communication_test;

/**
 * 线程通信（使两个线程交替进锁）
 * ex：使用连个线程交替打印1~100；
 *
 * 线程通信的三个方法
 * wait（）：一旦执行此方法，当前线程就会进入阻塞状态，并会释放同步监视器
 * notify（）：执行此方法会唤醒被wait（）的一个优先级最高的线程
 * notifyAll（）执行此方法会唤醒所有被wait的线程
 *
 * 这三个方法都必须声明在同步方法或同步代码块中；
 * 这三个方法的调用者必须是同步监视器否者出现IllegalMonitorStateException异常
 * 这三个方法是定义在 java.long.Object类中的
 *
 * sleep() vs wait()
 * 同：调用这两个方法都会使当前线程进入阻塞状态；
 *
 * 异：sleep（）定义在Thread类中，可以在任何有需求的场景调用，不会释放同步监听器
 *    wait（）定义在Object类中，只能在同步代码块或者同步方法中调用，会释放同步监听器
 *
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int number = 1;
//    private Object object = new Object();
    @Override
    public void run() {
        for(;;){
            synchronized (/*object*/this) {
                /*object.*/notify(); //激活阻塞线程

                if (number <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        /*object.*/wait(); //使线程阻塞，并释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (number > 100){
                return;
            }
        }
    }
}
