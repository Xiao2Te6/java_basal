public class DoWhileDemo1_10
{
    /* 演示while和do-while的区别
    （1）定义两个整数变量a和b
    （2）分别使用while和dowhile判断a > b*/
    public static void main(String[] args) {
        int a =3, b = 4;

        while (a > b){
            System.out.println("a > b");
        }

        do {
            System.out.println( "a > b");
        }while (a > b);
    }
}
