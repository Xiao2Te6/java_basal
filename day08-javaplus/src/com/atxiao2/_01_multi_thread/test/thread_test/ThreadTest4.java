package com.atxiao2._01_multi_thread.test.thread_test;

import java.util.concurrent.*;

/**
 *多线程创建方式四：使用线程池
 * 优点：
 * 1.提高响应速度（减少了创建线程的时间）
 * 2.降低资源损耗（重复利用线程池中的线程，不需要每次都创建）
 * 3.便于线程管理（可以设置线程池的属性）
 *          setCorePoolSize（）核心池大小
 *          setMaximumPoolSize（）：最大线程数
 *          setKeepAliveTime（）：线程没有任务时最多多长时间会终止（线程活跃时间）
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
//        ExecutorService service = Executors.newFixedThreadPool(10);//多态： 接口类型引用
        //设置线程池属性（类类型才有方 法）
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        service.setCorePoolSize(15);
//        service.setKeepAliveTime();
        //2.执行指定的线程操作,需要提供Runnable或Callable接口的实现类的对象
        //适用于Runnable接口创建实现类的多线程
        service.execute(new NumberThread2());
        //适用于Callable接口创建实现类的多线程
        service.submit(new FutureTask<Object>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                for (int i = 0; i < 100; i++){
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
                return null;
            }
        }));

        //3.关闭连接池
        service.shutdown();
    }
}

class NumberThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}