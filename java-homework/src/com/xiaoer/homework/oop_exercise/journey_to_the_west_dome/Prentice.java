package com.xiaoer.homework.oop_exercise.journey_to_the_west_dome;

public class Prentice
{
    private String mame;
    private int age;
    //武器
    private  String weapon;

    public Prentice() {
    }

    public Prentice(String mame, int age, String weapon) {
        this.mame = mame;
        this.age = age;
        this.weapon = weapon;
    }

    public String getMame() {
        return mame;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    //念佛
    public void buddha(){
        System.out.println("南无阿弥陀佛。。。。");
    }

    //取经
    public void doPilgrimage(){
        System.out.println("走了走了，出发了");
    }

    //战斗
    public void fight(){
        System.out.println("看我" + mame + "上去就是一" + weapon);
    }

    public void showinfo(){
        System.out.print("我" + mame + "活了" + age + "多年了什么场面没见过，想当年我拿着" + weapon + "，神挡杀神，魔挡杀魔，");
    }
}
