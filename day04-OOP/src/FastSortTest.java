import java.util.Arrays;

public class FastSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 65, 3, 1, 56, 8, 9, 75, 4, 43, 74, 85};
        System.out.println(arr.length);
        FastSort f = new FastSort();
        int len = arr.length - 1;
//        arr = f.qsort(arr, 0, len);
        f.fastSort(arr ,0, len);
        System.out.println(Arrays.toString(arr));
        }
    }


class FastSort {


    public int[] qsort(int arr[], int start, int end) {
        int key = arr[start];//定义比较对象key
        int i = start;   //左边遍历开始索引位置
        int j = end;      //右边遍历索开始引位置
        while (i < j) {    //当开始左右开始的索引位置相同时结束循环
            while ((i < j) && (arr[j] > key)) {//如果当前索引位置对应的值大小于等于key的值结束循环（此时arr[j]<k）
                j--;
            }
            while ((i < j) && (arr[i] < key)) { //如果当前i对应的索引位置大于等于key值结束循环（此时arr[i]>k）
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {//如果此时的arr[i]=arr[j],跳过这个i对应的值将j对应的值换到右边来
                i++;
            } else { //此时的arr[i]>=key,arr[j]<=key,且arr[i] != arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //换完过后小于key的到了左边，大于key的到了右边开车时下一轮while循环
            }
        }
        //循环结束后，比key大小的都到了左边比key大的都到了右边，i对应的值在key的左边最大，j对应的值在左边最小
        if (i - 1 > start) {  //如过i的索引大于初始索引，那么将此时的的i作为右历开始索引值递归调用qsout
            arr = qsort(arr, start, i - 1);
        }
        if (j + 1 < end) {  //如过j的索引小于于初始索引，那么将此时的的j作为左历开始索引值递归调用qsout
            arr = qsort(arr, j + 1, end);
        }
        return (arr);
    }

    public int[] fastSort(int[] arr, int starRight ,int starLeft){
        int key = arr[starRight];
        int i = starRight, j = starLeft;//右遍历和左遍历开始位置索引
        while(i < j){
            while ((i < j) && arr[i] < key){//如果当i<j没有即使跳出会栈溢出
                i++;
            }
            while ((i < j) && arr[j] > key){
                j--;
            }
             if (arr[i] == arr[j] && (i < j)){
                 j--;
             }else {
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
             }
        }
        if (i - 1 > starRight){
            fastSort(arr, starRight,i-1);
        }
        if (j + 1 < starLeft){
            fastSort(arr, j + 1 ,starLeft);
        }
        return arr;
    }
}



