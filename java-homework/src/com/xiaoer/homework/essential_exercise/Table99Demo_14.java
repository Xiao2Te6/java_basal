public class Table99Demo_14
{
    /*(1）傻B方式，逐行打印
    （2）普通方式，使用循环打印每一行
    （3）通过普通方式找到规律，写出最终通用版本作业要求*/
    public static void main(String[] args) {
        //1
        System.out.println("1X1=1 ");
        System.out.println("2X1=2 2X2=4");
        System.out.println("3X1=3 3X2=6 3X3=9 ");
        System.out.println("4X1=4 4X2=8 4X3=12 4X4=16");
        System.out.println("5X1=5 5X2=10 5X3=15 5X4=20 5X5=25");
        System.out.println("6X1=6 6X2=12 6X3=18 6X4=24 6X5=30 6X6=36");
        System.out.println("7X1=7 7X2=14 7X3=21 7X4=28 7X5=35 7X6=42 7X7=49");
        System.out.println("8X1=8 8X2=16 8X3=24 8X4=32 8X5=40 8X6=48 8X7=56 8X8=64");
        System.out.println("9X1=9 9X2=18 9X3=27 9X4=36 9X5=45 9X6=54 9X7=63 9X8=72 9X9=81");


        //2
        int i = 1;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;
        for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;for (int j = 1 ; j <= i; j++) {
            System.out.print(i + "X" + j + "=" + i * j + " ");
        }
        System.out.println();
        i++;

        //3
        for (int a= 1; a <=9; a++){
            for (int j = 1; j <= a; j++){
                String c = " ";
                if (a * j <= 4) {
                    c = "  ";
                }
                System.out.print(a + "X" + j + "=" + a*j + c);
            }
            System.out.println();
        }
    }
}
