import java.util.Scanner;

public class TestDemo3
{
    public static void main(String[] args) {

//        int i = 1;
//        while(i  < 101){
//            System.out.println("胖大海");
//            i++;
//        }
//        int i = 0;
//        for (;i < 3; System.out.println("c") ){
//            System.out.println("b");
//            i++;
//        }

//        //打印出100以内的偶数
//        int sum = 0;
//        for (int i = 1; i <= 100 ;i++){
//            if (i % 2 ==0 ) {
//                System.out.println(i);
//            }
//        }

//        //从键盘随机键入多个整数，统计正负个数，输入0结束；
//
//        Scanner scan = new Scanner(System.in);
//        int positiveNum = 0 ,negetiveNum = 0;
//        while (true){
//            System.out.println("请输入：");
//            int scanNum = scan.nextInt();
//            if (scanNum > 0 ){
//                positiveNum++;
//            }else if (scanNum < 0){
//                negetiveNum++;
//            }else{
//                break;
//            }
//        }
//        System.out.println("正数有：" + positiveNum + "个");
//        System.out.println("负数有：" + negetiveNum + "个");



//        //*
//        //**
//        //***
//        //****
//        //*****
//        //****
//        //***
//        //**
//        //*
//        for (int i = 1 ;i <=5 ; i++){
//            for (int a = 1; a <= i  ; a++ ){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for (int i = 1 ;i <=5 ; i++){
//            for (int a = 1; a <= 5 - i  ; a++ ){
//                System.out.print("*");
//            }
//            System.out.println();
//        }


//
//        //    *
//        //   ***
//        //  *****
//        // *******
//        //*********
//        //  *****
//        //   ***
//        //    *
//
//        //上部分
//        for (int i = 1 ; i <= 5  ; i++){       //行数控制
//            for (int b = 0; b <= 4 - i ;b++){   // 左边空格
//                System.out.print(" ");
//            }
//            for (int a = 1 ; a <= i; a++){   //中间*号
//                    System.out.print("*");
//            }
//            for (int a = 1 ; a <= i-1; a++){   //右边*
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        //下部分
//        for (int i = 1 ; i <= 5  ; i++) {
//            for (int b = 0; b <= i ; b++) {
//                System.out.print(" ");
//            }
//            for (int a = 1; a <= 3-i; a++) {
//                System.out.print("*");
//            }
//            for (int a = 1; a <= 4-i; a++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//
//        //九九乘法表
//        for (int i= 1;i <=9; i++){
//            for (int j = 1;j <= i;j++){
//                String c = " ";
//                if (i * j <= 4) {
//                    c = "  ";
//                }
//                System.out.print(i + "X" + j + "=" + i*j + c);
//            }
//            System.out.println();
//        }



//
//        //倒九九乘法表
//        for (int i= 9;i >= 1; i--) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i + "X" + j + "=" + i * j + " ");
//            }
//            System.out.println();
//        }


        //输出1万以内的质数
        long startTime = System.currentTimeMillis(); //获取1980到现在时间
        int count = 0;
        labe1 : for (int i = 2; i < 10000; i++){
            for (int j = 2; j <= (Math.sqrt(i)); j++){ //遍历小于i平方根的数
                if (i % j == 0){  // 如果i能被j整除
                    continue labe1; // 跳过本次i循环
                }
            }
            count ++; //当i循环完成一次count ++
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("完成时间为：" +(endTime - startTime)); //ms
        System.out.println(count);
    }
}
