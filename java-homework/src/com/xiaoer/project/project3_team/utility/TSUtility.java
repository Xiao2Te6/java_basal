package com.xiaoer.project.project3_team.utility;

import java.util.Scanner;

public class TSUtility {
    private static  Scanner scanner = new Scanner(System.in);

    /**
     * 从键盘键入”Y“或”N“
     * @return 返回键入值
     */
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c != 'Y' || c != 'N'){
                break;
            }else {
                System.out.print("叫你输入‘Y’或者’N‘看不明白？ 重输：");
            }
        }
        return c;
    }

    /**
     * 从键盘键入一个长度长度不超过2的整数
     * @return 返回这个整数
     */
    public static int readInt(){
        int n;
        for (;;){
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("输入数字有误，请重新输入");
            }
        }
        return n;
    }

    /**
     * 提示并等待直到用户按回车建后返回
     */
    public static void readReturn (){
         System.out.print("按回车继续...");
         readKeyBoard(100,true);
     }

    /**
     * 该方法读取键盘， 如果用户键入”1~4“中的任意一个数字则返回用户键入的字符
     * @return 用户键入的字符
     */
    public static char readMenuSelaction(){
        char c;
        while (true){
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4'){
                System.out.print("只有4个数，看不看得来！重输：");
            }else {
                break;
            }
        }
        return c;
    }

    private static  String readKeyBoard(int limit, boolean blankReturn){
        String line = "";
        while(scanner.hasNextLine()){   //当scanner有输入时返回true，进入循环
            line = scanner.nextLine();
            if (line.length() == 0){
                if (blankReturn){
                    return line;
                }else{
                    continue;
                }
            }
            if (line.length() > limit || line.length() < 1){
                System.out.print("输入长度（不得大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }


}
