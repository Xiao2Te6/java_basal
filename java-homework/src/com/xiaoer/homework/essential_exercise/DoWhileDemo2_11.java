public class DoWhileDemo2_11
{
    /*（1）使用do-while循环打印500次“帅哥”
        (2)使用do-while循环求出100以内的正整数之和*/
    public static void main(String[] args) {
        int a = 1, b = 1 , sum = 0;
        do {
            System.out.print("帅哥 ");
            a++;
        }while (a <= 500);

        do {
            sum += b;
            b++;
        }while (b < 100);
        System.out.println(b);
    }
}
