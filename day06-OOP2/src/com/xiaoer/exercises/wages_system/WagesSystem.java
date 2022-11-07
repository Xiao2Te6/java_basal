package com.xiaoer.exercises.wages_system;

import java.util.Calendar;

public class WagesSystem {
    public static void main(String[] args) {
        //获取当前月份
        Calendar instance = Calendar.getInstance();
        int month = instance.get(Calendar.MONTH);

        Employee[] emps = new Employee[2];
        emps[0] = new SalariedEmployee("胖大海", 1002 ,new MyDate(1998, 8, 22),10000);
        emps[1] = new HourlyEmployee("高贵妃",1001,new MyDate(1999,10,21),100,50);

        for (int i = 0; i < emps.length; i++){
            if (month + 1 == emps[i].getBirthday().getMonth()){
                System.out.println(emps[i]);
                System.out.println("生日快乐，补贴一百");
                double salary = emps[i].earnings();
                System.out.println("月工资为：" + (salary + 100));
            }else {
                System.out.println(emps[i]);
                double salary = emps[i].earnings();
                System.out.println("月工资为：" + salary);
            }


        }
    }
}
