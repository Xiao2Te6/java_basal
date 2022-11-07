import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest
{
    public static void main(String[] args) {

        //1.声明一个数组变量并进行初始化
        //静态初始化ids数组：数组的初始化和赋值同时进行
        int[] ids = new int[]{10,20,30,40};     //int类型元素数组
        //  另外写法
        int[] arr21 = {1,2,3,4,5};  //类型推断
        int arr22[] = new int[]{1,2,3,4,5};

        //动态初始化：数组的初始化和赋值分开进行
        String[] names = new String[5];     //Sting类型元素数组
        //赋值(数组长度固定，索引从0开始到素组长度-1结束)
        names[0] = "何";
        names[1] = "苟";
        names[2] = "高";
        names[3] = "龙";
        names[4] = "王";

        //2.获取数组长度，使用length属性
        System.out.println(names.length);   //5
        System.out.println(ids.length);     //4

        //3'遍历数组
//        System.out.println(names[0]);
//        System.out.println(names[1]);
//        System.out.println(names[2]);
//        System.out.println(names[3]);
//        System.out.println(names[4]);
        //循环遍历
        for (int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
        //无索引值
        for (String name: names){
            System.out.print(name + " ");
        }
        System.out.println();


        //4.数组的默认初始化值
        // >数组元素是整型初始化值：0
         int[] arr = new int[2];
        System.out.println(arr[0]);

        // >数组元素数是char型初始化值为：0
        char[] arr1 = new char[2];
        System.out.println(arr[0]);

        // >数组元素是boolean 类型初始化值为：false
        boolean[] arr2 = new boolean[2];
        System.out.println(arr2[0]);

        // >  数组元素是引用数组类型类型初始化值为： null
        String[] arr3 = new String[2];
        System.out.println(arr3[0]);

        //5. 数组赋值数组 (堆空间中只有arr4开辟的空间，赋值时只是将arr4对应空间的地址值
        //              赋给了arr5，当arr4对应空间的值修改后，遍历arr5的值也会变化
        //              （类似与给arr4创建了一个快捷方式arr5）)
        int[] arr4, arr5;
        arr4 = new int[]{10,20,40,32};
        for (int i = 0;i < arr4.length; i++){
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        arr5 = arr4; //数组赋值数组时两个数组类型得一样
        arr4[1] = 1;
        for (int i = 0;i < arr4.length; i++){
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        for (int i = 0;i < arr5.length; i++){
            System.out.print(arr5[i] + " ");
        }

        //6.数组复制
        int[] arr6, arr7;
        arr6 = new int[]{10,20,40,32};
        arr7 = new int[arr6.length];
        for (int i = 0;i < arr7.length; i++){
            arr7[i] = arr6[i];
            System.out.println(arr7[i] + " ");
        }

         //7.数组的反转
        String[] arr8 = new String[]{"aa","bb","cc","dd","ee"};
        String temp;
         for (int i = 0; i < arr8.length / 2; i++){
             temp = arr8[i];
             arr8[i] = arr8[arr8.length - i - 1];
             arr8[arr8.length - i -1] = temp;
         }
         //遍历
        for (int i = 0; i < arr8.length; i++){
            System.out.print(arr8[i] + " ");
        }

        //8.查找
        //线性查找
        String[] arr9 = new String[]{"aa","bb","cc","dd","ee"};
        String dest = new String();
        dest = "CC";
        boolean flag = false;
        for(int i = 0; i < arr9.length; i++){
            if (dest.equals(arr9[i])){
                System.out.println("找到了，这个值的位置在：" + i);
                flag = true;
                break;
            }
        }
        if (flag == false){
            System.out.println("很遗憾没找到");
        }

        //二分法查找（只适合有序数列）
        int[] arr10 = new int[]{-45,-1,5,43,76,102,324};
        int dest1 = 43;
        int startIndex = 0;
        int endIndex = arr10.length - 1;
        boolean flag1 = false;
        for(;startIndex <= endIndex;){
            int midIndex = (startIndex + endIndex) /2;
            if( arr10[midIndex] == dest1){
                System.out.println("找到了，这个值的位置在：" + midIndex);
                flag1 = true;
                break;
            }else  if ( arr10[midIndex] > dest1){
                endIndex = midIndex;
            }else{
                startIndex = midIndex;
            }
        }
        if (flag1 == false) {
            System.out.println("很遗憾没找到");
        }

        //9.排序（冒泡排序 BubbleSort）
        int[] arr11 = new int[]{75,32,45,1,43,29,64,38};
        for (int i = 0; i < arr11.length - 1; i++){
            for (int j = 0; j < arr11.length - 1 - i; j++){
                if (arr11[j] > arr11[j + 1]){
                    int temp1 = arr11[j];
                    arr11[j] = arr11[j + 1];
                    arr11[j+1] = temp1;
                }
            }
        }
        System.out.println(Arrays.toString(arr11));

    }
}
