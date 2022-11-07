package com.xiaoer.homework.interface_exercise.cise06;

/**
 *现有交通工具(Seater)，出租车（Taxi），客机（Airliner），客船（Ship）都属于交通工具。
 * 各交通工具都有品牌(brand)字段和载客行为（manned）。
 * 客机实现了IFly接口中定义的飞天的功能fly（），
 * 出租车实现了IRun接口中定义的道路上跑的功能run（），
 * 客船实现了ISwim接口中定义的游的功能swim（）。
 */
public class TestDome {
    public static void main(String[] args) {
        Taxi taxi = new Taxi("捷达汽车");
        taxi.manned();
        taxi.run();

        Airliner airliner = new Airliner("波音飞机");
        airliner.manned();
        airliner.flay();

        Ship ship = new Ship("泰但尼克号");
        ship.manned();
        ship.swim();
    }
}
