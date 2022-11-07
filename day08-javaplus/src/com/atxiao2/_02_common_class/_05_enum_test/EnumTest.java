package com.atxiao2._02_common_class._05_enum_test;

/**
 * Enum（枚举类）
 *   理解：类的对象只有有限个，确定的
 *   1.创建一组有限个数，确定的对象时，推荐用枚举类
 *   2.定义一组常量时建议使用枚举类
 *   3，如果枚举类只有一个对象可以当作单例模式的方式实现
 *
 *  方式一：jdk5.0之前 自定义枚举类
 *
 *  方式二：使用enum关键字定义枚举类
 */
public class EnumTest {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);
    }

}

//自定义枚举类
class Season{
    //1.声明Season属性，并用final修饰
    private final String seasonName;//季节名
    private final String seasonDesc;//季节描述

    //2.私有化构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春困");
    public static final Season SUMMER = new Season("夏天", "夏乏");
    public static final Season AUTUMN = new Season("秋天", "秋倦");
    public static final Season WINTER = new Season("冬天", "冬眠");

    //4.其他诉求： （1）获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //（2）提供toString方法

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}