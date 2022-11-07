package com.xiaoer.homework.oop_exercise.journey_to_the_west_dome;

public class ZhuBaJei extends Prentice
{
    //媳妇
    private String wife;

    public ZhuBaJei() {
    }

    public ZhuBaJei(String mame, int age, String weapon, String wife) {
        super(mame, age, weapon);
        this.wife = wife;
        showinfo();
        System.out.print("手搂着" + this.wife + "，脚踩南天门，手撕二郎神" );
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    //牵马
    public void holdHorse(){
        System.out.println("白龙马蹄儿朝西，嘿嘿");
    }

}
