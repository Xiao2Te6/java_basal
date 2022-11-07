package com.atxiao2._01_multi_thread.exercise.multi_thread_demo;

/**
 * 买票小测试，三个窗口同时卖票:用继承Thread方法
 * （线程不安全）
 */
public class MultiThreadDemo {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        for (;;){
            if( ticket > 0){
                System.out.println(getName() + "还有" + ticket + "票");
                ticket--;
            }else {
                break;
            }

        }
    }
}