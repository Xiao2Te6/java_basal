public class SevenDemo_20
{
    /*求 [1, 500] 之间能整除 7 的数的总和。思路：
        （1）遍历1-500的数
        （2）定义一个变量sum，
        （3）判断当前的数能被7整除，变量sum和当前遍历的数进行相加*/
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 500; i++){
            if(i % 7 ==0){
                sum += i;
            }{
                continue;
            }
        }
        System.out.println(sum);
    }
}
