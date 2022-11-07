public class ChangeVariableDemo2
{
    public static void main(String[] args) {
        //定义一个变量Number1并赋值
        int number1 = 10;
        //定义一个变量Number2并赋值
        int number2 = 50;
        //定义一个空变量temp
        int temp;
        //打印交换前的number1和number2
        System.out.println("交换前：\n"  + "number1 = " + number1 + "\n" +"number2 = " + number2);

//      //方法一
        /**将number1赋值给temp ，将number2赋值给number1，
         * 将temp赋值给number2，使number1和number2值交换
         */
//        temp = number1;
//        number1 = number2;
//        number2 = temp;
//        //打印交换后的number1和number2
//        System.out.println("交换后:\n"  + "number1 = " + number1 +"\n"  +"number2 = " + number2);


//        //方法二，只适用与数值运算，容易溢出，不用定义新变量。
//        number1 = number1 + number2;
//        number2 = number1 - number2;
//        number1 = number1 - number2;
//        System.out.println("交换后:\n"  + "number1 = " + number1 +"\n"  +"number2 = " + number2);



        //方法三，使用位运算符,不容易溢出，但也只适用与数值运算
        number1 = number2 ^ number1;
        number2 = number1 ^ number2;
        number1 = number1 ^ number2;
        System.out.println("交换后:\n"  + "number1 = " + number1 +"\n"  +"number2 = " + number2);
    }
}
