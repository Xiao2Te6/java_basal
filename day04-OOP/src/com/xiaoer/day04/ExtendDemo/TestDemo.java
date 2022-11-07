package com.xiaoer.day04.ExtendDemo;

public class TestDemo {
    public static void main(String[] args) {
        Teacher tea = new Teacher();
        //设置父类属性
        tea.setName("王师");
        System.out.println(tea.getName());
        tea.setAge(18);
        System.out.println(tea.getAge());
        //设置子类属性
        tea.setLevel(1);
        System.out.println(tea.getLevel());
        //调用子类方法
        tea.teach();
        //调用父类方法
        tea.rest();
        System.out.println("-----------------------------");

        Student stu = new Student();
        //设置父类属性
        stu.setName("胖大海");
        stu.setAge(2);
        //设置子类属性
        stu.setStudentid(444);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getStudentid());
        //调用子类方法
        stu.study();
         //调用子类重写方法
        stu.rest();

        System.out.println("受不了了，太累了");
        stu.toRest();
    }

}
