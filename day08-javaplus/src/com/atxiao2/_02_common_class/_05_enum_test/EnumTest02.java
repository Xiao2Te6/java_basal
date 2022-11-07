package com.atxiao2._02_common_class._05_enum_test;



/**
 * enum 常用方法
 *
 * toString()：输出对象名
 * values()： 返回枚举类所有对象的数组
 * valueOf(): 根据枚举类对象名，返回枚举类对象
 *
 * 枚举类实现接口或抽象方法,如果要使每一个对象的接口方法都不一样，则可以使用匿名内部类的方式
 */
public class EnumTest02 {
    public static void main(String[] args) {
        Season02 summer = Season02.SUMMER;
        System.out.println(summer);
        //toString()
        System.out.println(summer.toString());
        System.out.println("---------------------");

        //values()
        Season02[] values = Season02.values();
        for (Season02 value : values) {
            System.out.println(value);
            value.show();
        }
        System.out.println("---------------------");
        //valueOf():
        Season02 spring = Season02.valueOf("SPRING");
        System.out.println(spring);
    }
}
interface Info{
    void show();
}

//使用enum关键字定义枚举类
enum Season02 implements Info{

    //3.提供枚举类的多个对象
    SPRING("春天", "春困"){
        @Override
        public void show() {
            System.out.println("春天很美好");
        }
    },
    SUMMER("夏天", "夏乏"){
        @Override
        public void show() {
            System.out.println("夏天很热");
        }
    },
    AUTUMN("秋天", "秋倦"){
        @Override
        public void show() {
            System.out.println("秋天很美好");
        }
    },
    WINTER("冬天", "冬眠"){
        @Override
        public void show() {
            System.out.println("冬天很冷");
        }
    };


    //1.声明Season属性，并用final修饰
    private final String seasonName;//季节名
    private final String seasonDesc;//季节描述

    //2.私有化构造器，并给对象属性赋值
    private Season02(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求： （1）获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // @Override
    // public void show() {
    //
    // }

    //（2）提供toString方法 （enum类默认返回对象名）
    //
    // @Override
    // public String toString() {
    //     return "Season{" +
    //             "seasonName='" + seasonName + '\'' +
    //             ", seasonDesc='" + seasonDesc + '\'' +
    //             '}';
    // }
}
