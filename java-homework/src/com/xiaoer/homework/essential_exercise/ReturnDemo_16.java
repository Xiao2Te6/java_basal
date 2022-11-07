public class ReturnDemo_16
{
    /*从1输出到10，当迭代变量为7，就终止程序
    （1）循环打印1到10
    （2）判断循环次数是否为7，是就终止程序，否则打印循环次数*/
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i == 7){
               return;
            }else {
                System.out.println("i");
            }
        }
    }
}
