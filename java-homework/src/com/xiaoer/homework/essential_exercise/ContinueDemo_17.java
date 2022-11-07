public class ContinueDemo_17
{
    /*从1输出到10，不要输出4
    （1）循环遍历1到10的数
    （2）判断如果i为4，跳过当前循环，否则打印i*/
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i == 4){
                continue;
            }else {
                System.out.println("i");
            }
        }
    }
}
