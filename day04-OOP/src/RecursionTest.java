public class RecursionTest {
    public static void main(String[] args) {
        Recursion r1 = new Recursion();
        System.out.println(r1.f(10));
        System.out.println(  + r1.f1(10));

        int n = 10;
        System.out.println("f3 = " + r1.f2(n));
        r1.f2print(n);

    }
}

class Recursion {

    //递归测试1
    public int f(int n) {
        if (n == 0 ){
            return 1;
        }else if (n == 1){
            return 4;
        }else {
            return 2*f(n - 1) + f( n - 2);
        }

    }

    //递归测试2
     public int f1(int n){
        if (n == 20){
            return 1;
        }else if (n == 21){
            return 4;
        }else {
            return f1(n + 2) - 2*f1(n + 1);
        }
     }

     // 递归测试3斐波那契数列
    public int f2(int n){

        if (n == 1 || n == 2){
            return 1;
        }else {
            return f2(n-1)+f2(n-2);

        }

    }
    //斐波那契数列的输出
    public void f2print(int n){
        System.out.println("f(n)= " + f2(n));
        String str = new String();
        str = "{";
        for (int i = 1; i <= n ;i++ ){
            if (i == n){
                str +=f2(n) + "}";
            }else{
                str += f2(i) + ",";
            }
        }
        System.out.println(str);
    }
}
