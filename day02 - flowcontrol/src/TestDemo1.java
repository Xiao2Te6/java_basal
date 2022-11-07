import java.util.Scanner;

public class TestDemo1
{
    public static void main(String[] args) {

        //从键盘键入一个数
        System.out.println("请输入qq天数：");
        Scanner scan = new Scanner(System.in);
        int scanNum =  scan.nextInt();

//        if (scanNum > 0 && scanNum < 5){
//            System.out.println("天数太少，继续加油哦！");
//        }else if (scanNum >= 5 && scanNum < 12){
//            System.out.println("你的qq等级为：⭐");
//        }else if (scanNum >= 12 && scanNum < 21){
//            System.out.println("你的qq等级为：⭐⭐");
//        }else if (scanNum >= 21 && scanNum < 32){
//            System.out.println("你的qq等级为：⭐⭐⭐");
//        }else {
//            System.out.println("你的qq等级为：🌙");
//        }

        //优化后的
        if(scanNum > 0){
            if (scanNum < 5){
                System.out.println("天数太少，继续加油哦！");
            }else if (scanNum < 12){
                System.out.println("你的qq等级为：⭐");
            }else if (scanNum < 21){
                System.out.println("你的qq等级为：⭐⭐");
            }else if (scanNum < 32){
                System.out.println("你的qq等级为：⭐⭐⭐");
            }else {
                System.out.println("你的qq等级为：🌙");
            }

        }else {
            System.out.println("天数没有负数哦");
        }
    }
}
