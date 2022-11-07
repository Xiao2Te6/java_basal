public class MonthChooseDemo_18
{
    /*定义一个 int 类型 变量存放当前月份（month），
    使用 switch 进行判断，
    例如 3 月到 5 月是打印春季，6 月到 8 月打印夏季，
    依次类推打印秋季和冬季，但月份不是 1 月到 12 月，打印月份非法。*/
    public static void main(String[] args) {
        int month = 5;
        switch (month){
            case 3:
            case 4:
            case 5:
                    System.out.println("春天");
                    break;
            case 6:
            case 7:
            case 8:
                    System.out.println("夏天");
                    break;
            case 9:
            case 10:
            case 11:
                    System.out.println("秋天");
                    break;
            case 12:
            case 1:
            case 2:
                    System.out.println("冬天");
                    break;
            default:
                System.out.println("请输入1~12");
                    break;
        }
    }
}
