public class CircleDemo
{
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 2;
        System.out.println("area" + c1.findArea());

        CircleDemo ci1 = new CircleDemo();
        System.out.println(ci1.area(4,5));

    }

    //打印一个m*n的一个矩阵
    public int area (int m,int n){
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return m * n ;
    }
}

class Circle {
    double radius;

    public double findArea(){
        double area = Math.PI * radius * radius;
        return area;
    }
}
