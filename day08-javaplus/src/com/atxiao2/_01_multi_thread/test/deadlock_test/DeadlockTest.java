package com.atxiao2._01_multi_thread.test.deadlock_test;

/**
 * 死锁的演示（即不报错，也不结束，没有提示，也没有结果）
 */
public class DeadlockTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("1");
                    s2.append("a");

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(s2){
                        s1.append("2");
                        s2.append("b");
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2){
                    s1.append("3");
                    s2.append("c");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("4");
                        s2.append("d");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
