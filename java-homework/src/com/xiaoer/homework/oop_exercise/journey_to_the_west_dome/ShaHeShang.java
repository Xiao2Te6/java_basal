package com.xiaoer.homework.oop_exercise.journey_to_the_west_dome;

public class ShaHeShang extends Prentice
{   //流沙河
    private String sandRiver;

    public ShaHeShang() {
    }

    public ShaHeShang(String mame, int age, String weapon, String sandRiver) {
        super(mame, age, weapon);
        this.sandRiver = sandRiver;
        showinfo();
        System.out.print("居然被困在了" + sandRiver);
    }

    public String getSandRiver() {
        return sandRiver;
    }

    public void setSandRiver(String sandRiver) {
        this.sandRiver = sandRiver;
    }

    // 挑行李
    public  void  pickUpLuge(){
        System.out.println("挑行李真累啊。。。");
    }
}
