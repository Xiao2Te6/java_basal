package com.xiaoer.homework.interface_exercise.cise07;

public class NetworkOperator
{
    private String name;
    private String type;

    public NetworkOperator() {
    }

    public NetworkOperator(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void installBroadband(){
        System.out.println("安装我们" + name + "的宽带是最好的选择");
    }
    public void installCableTV(){
        System.out.println("安装我们" + name + "的有限电视您真有品味");
    }
}
