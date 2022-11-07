public class IfElseIfElseDemo2_04
{
    /*（1）定义一个整数类型的变量weekday
    （2）判断变量weekday，如果weekday为1输出“周一”，如此类推*/
    public static void main(String[] args) {
        int days = 2;

        if (days == 1){
            System.out.println("今天周一");
        }else if(days == 2){
            System.out.println("今天周二");
        }else if(days == 3){
            System.out.println("今天周三");
        }else if(days == 4){
            System.out.println("今天周四");
        }else if(days == 5){
            System.out.println("今天周五");
        }else if(days == 6){
            System.out.println("今天周六");
        }else if(days == 7){
            System.out.println("今天周日");
        }else {
            System.out.println("请输入1~7");
        }
    }
}
