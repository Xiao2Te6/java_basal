import javax.print.attribute.standard.NumberUp;

public class TestDemo10
{
    public static void main(String[] args) {
        //拓展一：算利息
        int tuition = 16000;
        double interest = 0.01;
        System.out.println("一个月后应该还的钱为：" + (interest * tuition + tuition) +
                            "\n12个月后应该还的钱为：" + (tuition + interest * tuition * 12));

        //拓展二:算数运算
        int number = 345;
        System.out.println( "\n \n个位上的值为：" + (number%10) +
                            "\n十位上的值为：" + (number/10%10) +
                            "\n百位上的值为：" + (number/100));

    }
}
