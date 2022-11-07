public class IfElseDemo_02
{
    /*(1)定义一个整数类型的变量a
    （2）判断a是奇数还是偶数，如果是偶数打印“a是偶数”，否则打印“a是奇数”*/
    public static void main(String[] args) {
        int a = 10;
        if (a % 2 == 0){
            System.out.println("偶数");
        }else{
            System.out.println("奇数");
        }
    }
}
