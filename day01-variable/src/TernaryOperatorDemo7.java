public class TernaryOperatorDemo7
{
    public static void main(String[] args) {

//        System.out.println((90 > 45) ? "数值大的为：" + 90 : "数值大的为：" + 54);
//
//        System.out.println("需要" + ((55/10)+1) + "页纸");
//
//        System.out.println("90为" + ((90%2) == 0 ? "偶数" : "奇数"));
        //比较数的大小
        int a = 99 , b = 20;
        int max = a > b ? a : b;
        System.out.println("\n大的是" + max );

//        求奇偶
        int m = 21431241;
        String s = m % 2 == 0 ? "\nm是偶数" : "\nm是奇数";
        System.out.println(s);

        //总数为x，每行页条数据，求需要多少页
        int x = 55;
        int pagecount=x / 10,pagecount1 = x / 10 + 1;
        int pagecount2 = x % 10 == 0 ? pagecount : pagecount1;
        System.out.println(pagecount2);
    }
}
