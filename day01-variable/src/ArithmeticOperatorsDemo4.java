public class ArithmeticOperatorsDemo4
{
    public static void main(String[] args) {
        // 定义两个变量a，b
        int a = 15;
        int b = 4;
        //输出这两个数字加减乘除和取模的结果
        System.out.println(
                "a+b=" + (a+b) + "\n" + "a-b=" + (a-b) + "\n"
                + "a*b=" + (a*b) + "\n" + "a/b=" + (a/b) + "\n" + "a%b=" + (a%b)
        );

        //因为8765和1000为int类型，计算结果将自动转换成int型，精度缺失
        System.out.println("8756/1000&*1000=" + 8756/1000*1000);

        //除数不能为0
       // System.out.println("10/0=" + 10/0);


        //  ++1和1++
        int x = 1;
        int y;
        y = ++x;
        System.out.println("x=" + x);
        System.out.println("y=" + y);

        int x1 = 1;
        int y1;
        y1 = x1++;
        System.out.println("x1=" + x1);
        System.out.println("y1=" + y1);


    }
}
