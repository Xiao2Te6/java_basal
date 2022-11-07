package com.xiaoer.innerclass_test;

/**
 * 类部类
 */
public class Animal {
    String name = "小动物";
    int age;
    //成员类部类
    //非静态类部类
    class Dog{
        String name = "修勾";
        public void shout(){
            Animal.this.age = 18;
            System.out.println(Animal.this.name);
            System.out.println(this.name);
            System.out.println("汪，汪，汪");
        }
    }

    // 静态类部类
    static class Cat{
        public void shout(){
            System.out.println("喵，喵，喵");
        }
    }

    //局部类部类
    public Animal(){
         //构造器里类部类
        class Elephant{
            public void shout(){
                System.out.println("没听过");
            }
        }
    }
    {
        //代码块里类部类
        class Bird{
            public void shout(){
                System.out.println("叽，叽，叽，叽");
            }
        }
    }

    public void eat(){
        //方法里类部类
        class Monkey{
            public void shout(){
                System.out.println("你的零食是我的啦");
            }
        }
    }

    //类部类的使用(返回一个实现了接口的类的对象)
    public Comparable getComparable(){
        class MyComparable implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();
    }
}

class TestAnimal{
    public static void main(String[] args) {

        //静态成员类部类创建对象
        Animal.Cat cat = new Animal.Cat();
        cat.shout();

        //创建非静态类部类对象A
        Animal animal = new Animal();
        Animal.Dog dog = animal.new Dog();
        dog.shout();


    }
}
