import java.util.Scanner;

public class Hello
{
    public static void main(String[] args) {
        System.out.println("Hello, world!");

//        // 求c
//        boolean a = true , b = false;
//        int c = 40;
//        if(c++ == 40 && (b == true)){
//            c++;
//        }
//        System.out.println("c= " + c );
//
//        if(a == false || (++c == 43)){
//            c++;
//
//        }
//        System.out.println("c= " + c);

//        //定义三个数，找出最大的数；
//        int a = 20, b = 10, c=16;
//        int max = a > b && a > c ? a : (b > a && b > c ? b :  c);
//        System.out.println( "最大的数是" + max);s

//        //从键盘键入一个数判断条件
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入胖大海的成绩");
//        int result = scan.nextInt();
//        String str;
//        if (result == 100 ){
//            str = "奖励一辆宝马" ;
//        } else if (result >= 90 ){
//            str = "奖励一部最新的苹果手机";
//        }else if ( result>60){
//            str = "奖励一台苹果平板";
//        }else {
//            str = "奖励一个大耳刮子";
//        }
//
//        System.out.println(str);

       //从键盘键入三个数值，比较大小
        //使用Scanner类接收三个数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        double num1 = scan.nextDouble();

        System.out.println("请输入第二个数：");
        double num2 = scan.nextDouble();

        System.out.println("请输入第三个数：");
        double num3 = scan.nextDouble();


        double max=0, mid=0, min=0;

        if(num1 > num2){//将1和2比较，
            //如果1比2大，将1和3比较确定3的位置
            if(num1 < num3){
                max = num3;
                mid = num1;
                min = num2;
            }else if(num2 > num3){
                max = num1;
                mid = num2;
                min = num3;
            }else{
                max = num1;
                mid = num3;
                min = num2;
            }
        }else if (num1<num2){
            //如果1比2小，将2和3比较确定大小
            if(num2 < num3){
                max = num3;
                mid = num2;
                min = num1;
            }else if (num1 > num3){
                max = num2;
                mid = num1;
                min = num3;
            }else{
                max = num2;
                mid = num3;
                min = num1;
            }
        }
        System.out.println(max+">"+mid+">"+min);
    }



}
