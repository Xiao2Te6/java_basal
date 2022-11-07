public class ForDemo_12
{
    /*(1）使用for循环打印1到10
    （2）使用for循环计算100以内正整数之和*/
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
        }
        int sum = 0;
        for (int i = 1; i < 100; i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
