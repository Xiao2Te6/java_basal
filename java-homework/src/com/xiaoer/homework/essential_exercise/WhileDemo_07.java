public class WhileDemo_07
{
    /*(1）定义一个变量count，表示计数器
    （2）使用while循环，判断count是否小于10
    （3）打印“帅哥”和循环次数（4）计数器+1*/
    public static void main(String[] args) {
        int count = 1;
        while(count < 10){
            System.out.println("帅哥");
            System.out.println(count);
            count++;
        }
    }
}
