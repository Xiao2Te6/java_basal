import java.util.Scanner;

public class ArrayDemo
{
    public static void main(String[] args) {

//        //联系电话
//        int[] arr = new int[]{1,3,5,7,8};
//        int[] arr1 = new int[]{0,3,3,4,0,3,4,1,2,4,1};
//        String tel = new String();
//        for (int i=0; i < arr1.length; i++){
//            tel += arr[arr1[i]];
//        }
//        System.out.println("\n联系方式：" + tel);

        //输入几个同学的成绩判断成绩
        //获取学生人数
        System.out.println("请输入学生人数：");
        Scanner scan = new Scanner(System.in);
        int scanNum = scan.nextInt();
        //创建数组存放学生成绩
        int[] scores = new int[scanNum];
        for (int i = 0; i < scores.length; i++){
             System.out.println("请输入第" + (i+1) +"个同学的成绩：");
             scores[i] = scan.nextInt();
        }
        //判断学生成绩中的最高分
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++){
            if (maxScore < scores[i]){
                maxScore = scores[i];
            }
        }
        //判断学生成绩等级
        char scoreGrade  ;
        for(int i = 0; i < scores.length; i++){
            if (scores[i] >= (maxScore - 10)){
                scoreGrade = 'A';
            }else if (scores[i] >= (maxScore - 20)){
                scoreGrade = 'B';
            }else if (scores[i] >= (maxScore - 30)){
                scoreGrade = 'C';
            }else {
                scoreGrade = 'D';
            }
            System.out.println("第" + (i + 1) + "学生成绩为：" + scores[i] + "成绩等级为：" + scoreGrade);
        }

    }
}
