import java.util.Scanner;

public class LottreryGameDemo
{
    public static void main(String[] args) {
        //用math方法获取一个随机数
        int ran = (int)(Math.random() * 90 + 10);
        int ranBitNum , ranTenNum ,scanBitNum , scanTenNum;
//        System.out.println(ran);

        //用Scanner方法键入一个数据
        System.out.println("请输入一个两位数：");
        Scanner scan = new Scanner(System.in);
        int scanNum = scan.nextInt();

        //获取键入和随机数十位和个位的数值
        ranBitNum = ran % 10;
        ranTenNum = ran / 10;
        scanBitNum = scanNum % 10;
        scanTenNum = scanNum / 10;

        //输入数值一样且顺序正确为一等奖，顺序不正确为二等奖，
        //数值顺序位置正确一个数字为三等奖，顺序完全不正确，数字正确一个为四等奖
        if (ranBitNum == scanBitNum && ranTenNum == scanTenNum){
            System.out.println("恭喜获得一等奖");
        }else if (ranBitNum == scanTenNum && ranTenNum == scanBitNum){
            System.out.println("恭喜获得二等奖");
        }else if (scanBitNum == ranBitNum || scanTenNum == ranTenNum){
            System.out.println(" 恭喜获得三等奖");
        }else if (scanBitNum == ranBitNum || scanTenNum == ranBitNum){
            System.out.println("恭喜获得四等奖");
        }else {
            System.out.println("爬，废物！");
        }



    }
}
