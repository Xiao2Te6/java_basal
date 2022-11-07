public class WhileDemo3_09
{
    /*计算100以内的正整数和
    （1）定义一个变量number，表示加数
    （2）定义一个变量sum，表示前N个数之和
    （3）使用while循环，每循环一次sum和当前的number相加一次
    （4）number自增1*/
    public static void main(String[] args) {
        int number = 1, sum = 0;
        while (number < 100){
            sum += number;
            number++;
            System.out.println(sum);
        }
    }
}
