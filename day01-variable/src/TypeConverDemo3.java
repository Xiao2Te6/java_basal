public class TypeConverDemo3
{
    public static void main(String[] args) {
        //自动转换类型
        //char->int
        int intNum =  'a';
        System.out.println(intNum);

        //int->long
        long longNum = 300;
        System.out.println(longNum);

        //long->double
        double doubleNum = 1213513512143L;
        System.out.println(doubleNum);

        //类型自动提升
        //float+char->double
        float floatNum = 3.14F;
        char charNum = 'a';
        double result = floatNum+charNum;
        System.out.println(result);

        //char+short->int
        char charNum1 = 'b';
        short shortNum = 20;
        int result1 = charNum1+shortNum;
        System.out.println(result1);

        //类型强制转换
        //double->int
        double doubelNum1 = 3.925;
        int result2 = (int)doubelNum1;
        System.out.println(result2);//精度损失






    }
}
