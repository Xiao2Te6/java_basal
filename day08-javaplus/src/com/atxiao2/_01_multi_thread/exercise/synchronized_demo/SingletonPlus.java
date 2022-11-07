package com.atxiao2._01_multi_thread.exercise.synchronized_demo;

/**
 * 使用同步机制修改懒汉式单例模式中的安全问题
 */
public class SingletonPlus {
    public static void main(String[] args) {
        //创建对象
        B b =  B.getB();
    }
}

class B{
    private B (){
    }
    private static B b = null;

    public static /*synchronized*/ B getB(){ // 方法1 同步方法解决，此时的锁为当前类B
//       //方法一：效率低（每个线程都得判断）
//        synchronized (B.class) { //方法2 同步代码
//            if(b == null){
//                b = new B();
//            }
//            return b;
//        }
        //方法二：效率较高（只有前几次线程会进入锁内）
        if (b == null){
            synchronized (B.class) {
                if(b == null){
                    b = new B();
                }
            }
        }
        return b;
    }
}
