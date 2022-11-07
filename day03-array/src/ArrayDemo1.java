import java.util.Scanner;

public class ArrayDemo1 {
    public static void main(String[] args) {
//        //写一个杨辉三角形
//        //声明一个二维数组并初始化
//        int[][] yanghui = new int[10][];
//        for (int i = 0; i < yanghui.length; i ++){
//            yanghui[i] = new int[i+1];
//        }
//        //赋值+遍历
//        for (int i = 0; i < yanghui.length; i++){
//            for (int j = 0; j < yanghui[i].length; j++){
//                if (j  == i || j == 0){ //当j=i时为每一排的最后一个 j=0时为每一排的第一个
//                    yanghui[i][j] = 1;
//                }else {
//                    yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1];
//                }
//                System.out.print(yanghui[i][j] + " ");
//            }
//            System.out.println();
//        }

//        //声明一个长度为6的int型数组，在1~30之间随机赋值，元素值不能重复
//        //声明数组
//        int[] arr = new int[6];
//        //赋值
//        labe :for (int i = 0; i < arr.length; i++ ){
//            for (int j;;) {
//                int randomNum = (int)(Math.random() * 31 + 1); //生产随机数
//                if (randomNum == arr[i]) {  //比较随机数是否重复
//                    continue ;          //重复就跳过此次循环重新生成随机数
//                }else{
//                    arr[i] = randomNum;
//                    break;
//                }
//            }
//            System.out.println(arr[i]);
//        }

        //写一个二元数组的回型赋值  (美中不足：当输入的值为奇数时，最中心的数会被赋值两次)
        //声明一个二维数组
        System.out.println("请输入想要的回型数正方形边长：");
        Scanner scan = new Scanner(System.in);
        int scanNum = scan.nextInt();
        int[][] loopArr = new int[scanNum][scanNum];

        //赋值
        int countNum = 0;
        int maxi = scanNum - 1; //下边
        int maxj = scanNum - 1; //右边
        int mini = 0; //上边
        int minj = 0; //左边
        while (mini <= maxi) {
            for (int i = mini; i <= maxi; i++) {
                loopArr[mini][i] = ++countNum;
            }  //上边赋值
            mini++;
            for (int i = minj; i <= maxj; i++){
                loopArr[i][maxj] = ++countNum;
            }   //右边赋值
            maxj--;
            for(int i = maxj; i >= minj; i--){
                loopArr[maxi][i] = ++countNum;
            }   //下边赋值
            maxi--;
            for (int i = maxi; i >= mini; i--){
                loopArr[i][minj] = ++countNum;
            }   //左边赋值
            minj++;

        }

        //遍历
        for (int i = 0; i < loopArr.length; i++){
            for (int j = 0; j < loopArr[i].length; j++){
                if (loopArr[i][j] < 10 && loopArr[i][j] != 0 ){
                    System.out.print(" " + loopArr[i][j] + "  ");
                }else {
                    System.out.print(loopArr[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
