public class OverloadTest
{
    public static void main(String[] args) {
        Overload over = new Overload();
        over.getSum(3,5);
        over.getSum(3,3,5,1,5);
        over.getSum(3,5,4);
        over.getSum(3.5,5);
//        over.getSum(3,5.2);


    }
}

class Overload{

    //方法重载
   public int getSum(int a, int b){
       int sum = a + b;
       System.out.println(sum);
       return sum;
   }
    public int getSum(double a, int b){
        int sum = (int)a + b;
        System.out.println(sum);
        return sum;
    }
    public int getSum(int a, int b, int c){
        int sum = a + b;
        System.out.println(sum);
        return sum;
    }
    //可变个数参数
    public int getSum(int ... a){
       int sum = 0;
        for (int i = 0; i < a.length; i ++){
            sum += a[i];
        }
        System.out.println(sum);
        return sum;
    }
    //数组类型参数和可变个数参数冲突，不构成重载
//    public int getSum(int[] a,){
//        int sum = 0;
//        for (int i = 0; i < a.length; i ++){
//            sum += a[i];
//        }
//        return sum;
//    }
}