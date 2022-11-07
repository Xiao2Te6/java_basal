package com.xiaoer.homework.oop_exercise.phone;

public class PhoneTest
{
    public static void main(String[] args) {
        Phone phone = new Phone("Apple iPhone 12 (A2404)",6799.00,300.0f,"黑色",128);
        phone.showInfo();
        System.out.println();

        Phone phone1 = new Phone("Apple iPhone 13 (A2405)",7999.00,300.0f, "银色",128);
        phone.showInfo();

    }
}
