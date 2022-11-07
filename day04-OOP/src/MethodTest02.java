public class MethodTest02
{
    public static void main(String[] args) {
        double[] arr = new double[]{1.21,56.2,43.2,3.2,4};
        System.out.println("打折后为：" + MethodTest02.getTotalPrice(0.8,1.21,56.2,43.2,3.2,4));
    }
    public static double getTotalPrice(double couOff, double ... price){
        double total = 0.0;
        for (int i = 0; i < price.length; i++){
            total += price[i];
        }
        return total * couOff;
    }
}

