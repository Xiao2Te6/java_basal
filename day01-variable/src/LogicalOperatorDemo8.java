public class LogicalOperatorDemo8
{
    public static void main(String[] args) {
        System.out.println(true & false);
        System.out.println(true & true);
        System.out.println(true | false);
        System.out.println(true & true);
        System.out.println((false ^ false) + "\n");

        //&&为短路与，当第一个条件为假则不计算第二个条件
        boolean a = false ;
        int b = 10;
        if(a && (10 < b++)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println("b= " + b + "\n");

        // ||为短路或，当第一个条件为真则不计算第二个条件
        boolean a1 = true ;
        int b1 = 10;
        if(a1 || (10 < b++)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println("b= " + b);
    }
}
