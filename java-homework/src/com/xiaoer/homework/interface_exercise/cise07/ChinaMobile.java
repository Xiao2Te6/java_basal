package com.xiaoer.homework.interface_exercise.cise07;

public class ChinaMobile extends NetworkOperator implements ICallable,IInternetable,IChatable{

    public ChinaMobile(String name, String type) {
        super(name, type);
    }

    @Override
    public void call() {
        System.out.println("欢迎使用" + getName() + "，您现在可以正常通话了");
    }

    @Override
    public void internet() {
        System.out.println("欢迎使用" + getName() + "，您现在可以正常上网了");

    }

    @Override
    public void chat() {
        System.out.println("能聊天，牛*不");
    }
}
