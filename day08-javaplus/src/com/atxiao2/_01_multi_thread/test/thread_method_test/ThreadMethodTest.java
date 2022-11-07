package com.atxiao2._01_multi_thread.test.thread_method_test;

import static java.lang.Thread.MAX_PRIORITY;

/**
 *  测试Thread类常用方法
 *  start（）：启动当前线程；调用当前线程的run（）；
 *  run（）：通常需要重写Tread中的此方法，将创建的线程需要执行的操作声明在此方法中
 *  currentThread（）：静态方法，返回当前执行的线程
 *  getName（）：获取当前线程名字
 *  setName（）：设置当前线程的名字
 *  yield（）：释放当前cpu执行权
 *  join（）：在线程a中调用线程b的join（），此时线程a处于阻塞状态直到b进行完成
 *  stop（）；已过时，强制停止当前线程
 *  sleep（long millitime）：让当前线程阻塞（睡眠）指定毫秒（millitime）
 *  isAlive（）：判断当前线程是否存活
 *
 *  getPriority（）：获取线程优先级
 *  setPriority（int p）：设置线程优先级
 *      MAX_PRIORITY 最大优先级10
 *      NORM_PRIORITY 默认优先级5
 *      MIN_PRIORITY 最小优先级1
 *  高优先级线程会抢占低优先级线程的cpu执行权（概率上的，并不是高优先级的先执行完再执行低优先级的）
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread();
        t1.setName("线程一");
        t1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println(Thread.currentThread().getName() + ": hello，main");


        MyThread3 t2 = new MyThread3("线程二");
        t2.setPriority(MAX_PRIORITY);
        t2.start();

        for (int i = 0; i < 100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
//            if (i == 20){
//                try {
//                    //抢占线程
//                    t2.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        //判断t1线程是否存活
        System.out.println(t1.isAlive());
    }
}

class MyThread3 extends Thread {
    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if(i % 2 == 0){

//                try {
//                    //休息0.1秒执行
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": hello");
    }
}


