package com.xiaoer.main_test;

/**
 * 1.main()方法作为程序的入口
 * 2.main()方法也可以作为一个普通的静态方法
 * 3.因为main()方法是静态的，所以在main()方法中调用方法只能调用静态方法或者造对象
 * 4.main()方法也可以作为与控制台交互的方式
 */
public class MainTest {
    public static void main(String[] args) {
        Main main = new Main();
        main.main(new String[]{"1","2","3","4"});
    }
}

class Main{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
