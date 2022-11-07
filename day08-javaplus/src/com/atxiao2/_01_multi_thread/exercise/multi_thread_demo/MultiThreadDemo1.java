package com.atxiao2._01_multi_thread.exercise.multi_thread_demo;

/**
 * 买票小测试，三个窗口同时卖票:勇实现Runnable方法
 * （线程不安全 出现重票）
 */
public class MultiThreadDemo1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread thread = new Thread(w);
        Thread thread1 = new Thread(w);
        Thread thread2 = new Thread(w);

        thread.setName("窗口一 ：");
        thread1.setName("窗口二 ：");
        thread2.setName("窗口三 ：");

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        for (;;){
            if( ticket > 0){

//                //出现线程安全问题（出现错票）
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + "还有" + ticket + "票");
                ticket--;
            }else {
                break;
            }

        }
    }
}

