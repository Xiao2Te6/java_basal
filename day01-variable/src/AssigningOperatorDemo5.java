public class AssigningOperatorDemo5
{
    public static void main(String[] args) {
        //赋值运算符
        int age = 52;
        age += 10;
        System.out.println("age=" + age);

        short s = 5;
        s += 2;//s先加上2在赋值给s
        System.out.println("s=" + s);

        age += 10;
        System.out.println("age=" + age);

        age -= 10;
        System.out.println("age=" + age);

        age *= 10;
        System.out.println("age=" + age);

        age /= 10;
        System.out.println("age=" + age);

        age = 10;
        System.out.println("age=" + age);

        age %= 10;
        System.out.println("age=" + age);



    }
}
