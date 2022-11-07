public class Test02Variable0
{
    public static void main(String[] args)
    {
//        //声明一个变量age
//        int age;
//        age=250;
//        //使用变量
//        System.out.println(age);
//
//        //声明一个变量name 并赋值
//        String name= "胖大海";
//        System.out.println(name);

        int days = 47;
        int month,day;
        day = days % 30;
        month = days / 30;
        System.out.println("\n距离考试还有" + month +"个月" + day + " 天");

        double doubleNum = 5 / 2 + 1.0;
        double doubleNum1 = 5 / 2.0 + 1;
        System.out.println(doubleNum + "\n" + doubleNum1);
    }
}
