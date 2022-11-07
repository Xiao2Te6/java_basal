package com.atxiao2._01_multi_thread.test.lock_test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
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

class Window extends Thread {
    private static int ticket = 100;
    //创建ReentrantLock实例化对象
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        for (; ; ) {
            try {
                //调用锁定方法lock
                lock.lock();
                if (ticket > 0) {
//                    try {
//                        sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(getName() + "还有" + ticket + "票");
                    ticket--;
                }else{
                    break;
                }
            }finally{
                //调用解锁方法 unlock（）
                lock.unlock();
            }

        }
    }
}