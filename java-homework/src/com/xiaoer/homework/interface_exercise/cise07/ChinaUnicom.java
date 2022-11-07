package com.xiaoer.homework.interface_exercise.cise07;

/**
 * 中国联通
 */
public class ChinaUnicom extends NetworkOperator implements ICallable,IInternetable {

    public ChinaUnicom(String name, String type) {
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
