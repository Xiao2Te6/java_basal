import java.time.Year;
import java.util.Scanner;

public class TestDemo2
{
    public static void main(String[] args) {

//        Scanner scan =new Scanner(System.in);
//        int days = scan.nextInt();
//
//        switch (days){
//            case 1:
//                System.out.println("今天周一");
//                break;
//            case 2:
//                System.out.println("今天周二");
//                break;
//            case 3:
//                System.out.println("今天周三");
//                break;
//            case 4:
//                System.out.println("今天周四");
//                break;
//            case 5:
//                System.out.println("今天周五");
//                break;
//            case 6:
//                System.out.println("今天周六");
//                break;
//            case 7:
//                System.out.println("今天周日");
//                break;
//            default:
//                System.out.println("请输入1~7");
//        }

//        char Num = 'f';
//        switch (Num){
//            case'a' :
//            case'i' :
//            case'e' :
//            case'0' :
//            case'u' :
//                    {System.out.println("元音字母");
//                    break;}
//            default:{System.out.println("辅音字母");
//                    break;}
//        }

        //键入年月日，判断为该年的第几天
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = scan.nextInt();

        System.out.println("请输入月份");
        int month = scan.nextInt();

        System.out.println("请输入日期");
        int day = scan.nextInt();

        int sumDay = 0;

        switch (month){
            case 12: {
                sumDay += 31;
            }
            case 11: {
                sumDay += 30;
            }
            case 10: {
                sumDay += 31;
            }
            case 9: {
                sumDay += 30;
            }
            case 8: {
                sumDay += 31;
            }
            case 7: {
                sumDay += 31;
            }
            case 6: {
                sumDay += 30;
            }
            case 5: {
                sumDay += 31;
            }
            case 4: {
                sumDay += 30;
            }
            case 3: {
                sumDay += 31;
            }
            case 2: {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    sumDay += 29;
                }else {
                    sumDay += 28;
                }
            }
            case 1: {
                sumDay += day;
            }

        }
        System.out.println("这是" + year + "年的第" +  sumDay + "天");


    }
}
