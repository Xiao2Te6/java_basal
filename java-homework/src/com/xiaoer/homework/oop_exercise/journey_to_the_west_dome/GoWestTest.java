package com.xiaoer.homework.oop_exercise.journey_to_the_west_dome;

public class GoWestTest
{
    public static void main(String[] args) {

        SunWuKong wukong = new SunWuKong("老孙",5000,"大棒","紧箍咒");
        System.out.println();
        ZhuBaJei baJei = new ZhuBaJei("老猪",4329,"钉耙","翠兰");
        System.out.println();
        ShaHeShang shaSheng = new ShaHeShang("老沙",32748,"粪挑子","流沙河");
        System.out.println();
        shaSheng.fight();

    }
}
