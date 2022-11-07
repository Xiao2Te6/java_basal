package com.xiaoer.design_patterns.proxy;

/**
 * 代理模式
 */
public class ProxyTest
{
    public static void main(String[] args) {

        Computer computer = new Computer();
        ProxyNet proxyNet = new ProxyNet(computer);
        proxyNet.browse();

    }
}


interface INetWorkable{
    void browse();
}

/**
 * 被代理类
 */
class Computer implements  INetWorkable{

    @Override
    public void browse() {
        System.out.println("正经电脑联网");
    }
}

/**
 * 代理类
 *
 */
class ProxyNet implements INetWorkable{
    //创建被代理对象属性
    private INetWorkable net;

    public ProxyNet(INetWorkable net) {
        this.net = net;
    }

    public void check(){
        System.out.println("检查是否能联网");
    }

    //代理被代理类完成行为，并附加其他行为
    @Override
    public void browse() {
        check();
        net.browse();
    }
}
