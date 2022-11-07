public class MethodTest01
{
    public static void main(String[] args) {
        int n = 10 ,m = 20;
        int sum = MethodTest01.getSum(n,m);
        System.out.println(sum);

        //打印数组
        int[] arr = new int[]{1,2,4,5,6,7,8,9,1};
        System.out.println(MethodTest01.printArray(arr,"{","-","}"));

        //查找指定元素位置
        int index = MethodTest01.lookUp(null,2);
        if (index >= 0){
            System.out.println("位置在：" + index);
        }else {
            System.out.println("找不到");
        }

        //求数组平均值
        System.out.println("平均值为：" + MethodTest01.getAvg(arr));
    }

    public static int getSum(int num , int num2){
        int sum = num + num2;
        return sum;
    }

    /**
     *根据不同的格式打印数组
     * @param arr 需要打印的数组
     * @param start 括号头部
     * @param connect   中间的连接符
     * @param end 括号的尾部
     * @return 链接完成的数组
     */
    public static String printArray(int[] arr, String start, String connect,String end){
            String str = new String();
        str = start;
        for (int i = 0 ;i < arr.length; i++){
            if (i == arr.length - 1){
                str += arr[i] + end;
            }else {
                str += arr[i]  + connect;
            }
        }
        return str;
    }

    /**
     *查找指定元素
     * @param arr 指定数组
     * @param num 需要查找的元素
     * @return  指定元素的位置
     */
    public  static int lookUp(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                return  i;
            }
        }
        return  -1;
    }

    /**
     * 求数组平均值
     * @param arr 指定数组
     * @return     数组平均值
     */
    public static double getAvg(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return (sum * 1.0 / arr.length);
    }
}

