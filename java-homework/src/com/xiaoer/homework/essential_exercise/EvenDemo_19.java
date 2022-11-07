public class EvenDemo_19
{
    /*找出 [1, 500] 之间偶数的个数。
     （1）遍历1到500的数字
    （2）判断是否是偶数，能被2整除的就是偶数
    （3）定义变量count作为计数器，如果为偶数，count加1*/
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 500; i++){
            if(i % 2 ==0){
                count++;
            }{
                continue;
            }
        }
        System.out.println(count);
    }
}
