public class BreakDemo_15 {
    /*从1输出到10，当迭代变量为7，就停止循环
    （1）循环打印1到10
    （2）判断循环次数是否为7，是就停止循环，否则打印循环次数*/
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i == 7){
                break;
            }else {
                System.out.println("i");
            }
        }
    }
}
