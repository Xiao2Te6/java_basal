public class SwitchDemo_06
{
    /*(1）定义一个整数类型的变量weekday
    （2）判断变量weekday，如果weekday为1输出“周一”，如此类推*/
    public static void main(String[] args) {
        int weeekday = 5;

        switch (weeekday){
            case 1:
                System.out.println("今天周一");
                break;
            case 2:
                System.out.println("今天周二");
                break;
            case 3:
                System.out.println("今天周三");
                break;
            case 4:
                System.out.println("今天周四");
                break;
            case 5:
                System.out.println("今天周五");
                break;
            case 6:
                System.out.println("今天周六");
                break;
            case 7:
                System.out.println("今天周日");
                break;
            default:
                System.out.println("请输入1~7");
        }
    }
}
