package com.xiaoer.main_test;

public class MainTest1 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            System.out.println("--------" + args[i]);
            int intarg = Integer.parseInt(args[i]);
            System.out.println("***********" + intarg);
        }
    }
}
