import java.util.Arrays;

public class ArrayTest2
{
    public static void main(String[] args) {
        //Arrays 工具类的使用

        //1. equals 判断两个数组是否相等
        int[] arr = new int[]{1,2,3,4};
        int[] arr1 = new int[]{1,3,2,4};
        System.out.println(Arrays.equals(arr,arr1));

        //2.  toString 输出数组元素
        System.out.println(Arrays.toString(arr));

        //3. fill 将数组元素填充为一个值
        int[] arr2 = new  int[5];
        Arrays.fill(arr2,10);
        System.out.println(Arrays.toString(arr2));

        //4. sort 对数组排序
        int[] arr3 = new int[]{2,4,13,5,1,35};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        //5. Binarybearch 对数组进行二分法查找（如果没找到会返回一个负值）
        int index = Arrays.binarySearch(arr3,4);
        if (index <= 0){
            System.out.println("位置为：" + index);
        }else {
            System.out.println("没找到");
        }
    }
}
