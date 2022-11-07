public class ArrayTest1
{  //数组使用
    public static void main(String[] args) {
        //1.二位素组的初始化
        //静态初始化
        int arr[][] = new int[][]{{1,2,3},{1,2},{1,2,3,4}};
        int[][] arr1 = new int[][]{{1,2,3},{1,2},{1,2,3,4}};
        int arr2[][] = {{1,2,3},{1,2},{1,2,3,4}}; // 类型推断

        //动态初始化
        String[][] arr3 = new String[3][2];   //固定元素数组长度
        int[][] arr4 = new int[3][];    //不固定元素数组长度

        //2.调用二位数组指定位置的元素
        System.out.println(arr[0][2]); //3
        System.out.println(arr3[1][0]); //null

//        System.out.println(arr4[2][1]); //元素素组未初始化直接使用会报空指针错误
        arr4[2] = new int[4];   //使用只声明变量未初始化的元素数组时必须先初始化此元素数组
        System.out.println(arr4[2][1]); //0

        //3.获取数组长度
        System.out.println(arr.length); //3
        System.out.println(arr[1].length);//2

        //4.二维数组的遍历
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //5.二维数组的默认初始化
        System.out.println(arr3);       //会打印数组类型和数组在堆中空间的地址值([[表示二维数组)
        System.out.println(arr3[0]);    //会打印元素数组的类型和在堆中空间的地址（[表示一维数组）
        System.out.println(arr3[0][0]); //null



    }
}
