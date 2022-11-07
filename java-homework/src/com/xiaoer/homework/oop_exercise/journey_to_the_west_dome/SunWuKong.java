package com.xiaoer.homework.oop_exercise.journey_to_the_west_dome;

public class SunWuKong extends Prentice
{   //紧箍咒
    private String formula;

    public SunWuKong() {
    }

    public SunWuKong(String mame, int age, String weapon, String formula) {
        super(mame, age, weapon);
        this.formula = formula;
        showinfo();
        System.out.print("最后居然会爱上" + formula);
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    //降妖
    public void extDevil(){
        System.out.println("妖怪吃我一棒");
    }
}
