package com.atxiao2._07_reflection._06_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : XiaoEr
 * @date : 2022/11/1
 *
 * 动态代理的实现
 *      使用Proxy类调用newProxyInstance()静态方法生成对应的被代理类的代理对象
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new Superman());
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("辣椒");
        System.out.println();

        Animal dogProxy = (Animal) ProxyFactory.getProxyInstance(new Dog());
        dogProxy.walk();

    }
}

/**
 * 动态代理工厂（通过工厂获取对应代理类） 新特性
 */
class ProxyFactory{
    //返回指定对象T的代理类对象啊
    public static <T> Object getProxyInstance(T t){
        //使用Proxy类创建一个对应代理对象（被代理对象的类加载器，被代理对象实现的接口，代理类的处理者）
        return Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            //调用代理类中的方法时会调用该方法：invoke(代理类，被代理对象调用方法，被代理对象调用方法的参数)
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //Aop面向切面编程的体现
                System.out.println("*********通用方法一***********"); //动态代理增加的方法一
                Object returnValue = method.invoke(t, args);//回调目标对象的方法（动态不固定的）
                System.out.println("*********通用方法一***********");//动态代理增加的方法二
                return returnValue;
            }
        });
    }
}




/**
 * 被代理类一实现的接口
 */
interface Human{
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类一
 */
class Superman implements Human{

    @Override
    public String getBelief() {
        return "我是超人我会非";
    }

    @Override
    public void eat(String food) {
        System.out.println("我最喜欢吃" + food);
    }
}

/**
 *  被代理类二实现接口
 */
interface Animal{
    void walk();
}

/**
 * 被代理类二
 */
class Dog implements Animal{

    @Override
    public void walk() {
        System.out.println("走。。。。");
    }
}