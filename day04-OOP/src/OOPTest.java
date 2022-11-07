
// 创建类设计类的成员

import javax.xml.namespace.QName;

public class OOPTest
{
    public static void main(String[] args) {
        //创建类的对象p1
        //创建对象名  (指定)==>  //创建对象实体
        PersonTest p1 = new PersonTest();

        //调用成员变量 “对象.属性”
        p1.weight = 60;
        p1.height = 176;
        p1.name = "何圆";
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.sex);
        System.out.println(p1.weight);
        System.out.println(p1.height);

        //调用成员方法 “对象.方法”
        p1.eat();
        p1.sellp();
        p1.talk("普通话");

        //创建对象p2对比p1
        PersonTest p2 = new PersonTest();
        System.out.println(p2.name);

        //创建p3,将p1赋值给p3
        PersonTest p3 = p1;
        System.out.println(p3.name);
        p3.age = 20;
        System.out.println(p1.age);
        //p1 将堆中开辟空间的地址值赋值给了p3，p3和p1地址指向的同一个空间，所以修改p3，p1也会变


    }
}

class  PersonTest
{
     //设计成员变量（属性）
    int age = 10;
    char sex = '男';
    int height, weight;
    String name;


    //设计成员方法（方法或者函数）
     public void eat(){
        System.out.println("吃饭");
     }

     public void sellp(){
         //局部变量
         int time = 8;
         System.out.println("每天睡" + time + "小时");
     }

     public void talk(String language){
         System.out.println("会说" + language);
     }
}
