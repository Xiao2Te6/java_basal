public class LoopInLoopDemo_13
{
    /*输出直角三角形：
     （1）傻B方式，逐行打印
    （2）普通方式，使用循环打印每一行
    （3）通过普通方式找到规律，写出最终通用版本*/
    public static void main(String[] args) {
       //1
        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("*****");
        //2
        for (int i = 1; i<= 1; i ++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i<= 2; i ++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i<= 3; i ++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i<= 4; i ++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i<= 5; i ++){
            System.out.print("*");
        } System.out.println();
        //3
        for (int i = 1 ;i <=5 ; i++) {
            for (int a = 1; a <= i; a++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
