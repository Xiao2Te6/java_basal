package com.xiaoer.homework.interface_exercise.cise07;

/**
 * 中国电信
 */
public class ChinaTelecom extends NetworkOperator implements ICallable,IInternetable{

    public ChinaTelecom(String name, String type) {
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
}
