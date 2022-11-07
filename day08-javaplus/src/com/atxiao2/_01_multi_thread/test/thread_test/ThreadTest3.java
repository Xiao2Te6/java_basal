package com.atxiao2._01_multi_thread.test.thread_test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程创建方式三：实现Callable接口，并重写call方法
 *
 * Callable支持泛型，且call()可以有返回值、可以抛出异常并让外面捕获异常信息
 *
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        //3.创建该实现类的对象
        NumThread numThread = new NumThread();
        //4.用3创建的实现类对象作为构造器参数创建FutureTask类的对象
        FutureTask<Integer> future = new FutureTask<>(numThread);
        //5.用4创建的对象作为构造器参数创建Thread类的对象并的调用start方法启动多线程
        new Thread(future).start();

        //future.get()能获取Callable实现类中call（）的返回值
        try {
            System.out.println("总和为:" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
//1.创建一个实现了Callable接口的实现类
class NumThread implements Callable{
    //2.重写其call方法
    @Override
    public Object call() throws Exception { //输出100以内的数并返回每个数之和
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
