public class IfElseIfElseDemo_03
{
    /*（1）定义整数类型的两个数a和b
    （2）判断a和b的大小关系*/
    public static void main(String[] args) {
        int a=2, b=3;
        if (a > b){
            System.out.println("a大");
        }else if (a < b){
            System.out.println("b大");
        }else{
            System.out.println("一样大");
        }
    }
}
