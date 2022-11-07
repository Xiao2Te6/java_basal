package com.atxiao2._01_multi_thread.exercise.product_test;

public class Clerk {
    private int productCount;

    public synchronized void produceProduct(){
       if (productCount < 10){
               System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");
               productCount++;
               notify();

       }else{
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public synchronized void consumeProduct(){
        if (productCount > 0){

                System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
                productCount--;
                notify();

        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
