package com.atxiao2._08_java8_new_features._05_optional;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author : XiaoEr
 * @date : 2022/11/4
 *
 * Optional<T>:  是一个容器类，可以保存T类型的值
 *                  提供通过一系列方法避免存入容器类的值为null 从而避免 NullPointerException
 *      创建建立方式：
 *          Optional.of(T t): 创建一个Optional实例 t必须不为空
 *          Optional.empty(): 创建一个空的Optional实例
 *          Optional.ofNullable(T t)： 创建一个Optional实例，t可以为空
 *       常用方法：
 *          boolean isPresent(): 判断Optional实例是存有对象
 *          void ifPresent(Consumer<T> s): 如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传入
 *
 *          T get(): 返回掉用对象包含的值，如果为空就抛异常
 *          T orElse(T other): 如果有值就返回，如果没有值就返回指定的other对象
 *          T orElseGet(Supplier <T> other) 如果有值就返回，如果没有值就返回Supplier接口提供的对象
 *          T orElseThrow(Supplier<X> exceptionSupplier ) 如果有值就返回，否则抛出Supplier接口提供的异常对象
 */
public class OptionalTest {

    /**
     *  创建方法 演示
     */
    @Test
    public void test(){
        //创建一个Optional实例
        Optional<Boy> boy = Optional.of(new Boy());
        System.out.println("boy = " + boy);
        Optional<Object> empty = Optional.empty();
        System.out.println("empty = " + empty);
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println("o = " + o);
    }

    /**
     * 常用方法演示
     */
    @Test
    public void test2(){
        Optional<Boy> boy = Optional.of(new Boy(new Girl("小花")));
        System.out.println("boy = " + boy);
        Optional<Boy> o = Optional.ofNullable(null);
        System.out.println("o = " + o);

        //如果调用者为空则会返回other orElse()
        Boy boy1 = o.orElse(new Boy());
        System.out.println("boy1 = " + boy1);

        // getGirlFriendName(null);//空指针异常

        String girlFriendName1 = getGirlFriendName1(null);
        System.out.println("girlFriendName1 = " + girlFriendName1);

        //使用Optional优化
        String girlFriendName2 = getGirlFriendName2(null);
        System.out.println("girlFriendName2 = " + girlFriendName2);
    }

    /**
     * 原始 获取girlfriend的name  容易出现空指针
     */
    public String getGirlFriendName(Boy boy){
        return boy.getGirlfriend().getName();
    }

    /**
     * 优化 getGirlFriendName 避免出现空指针
     */
    public String getGirlFriendName1(Boy boy){
        if(boy != null){
            if (boy.getGirlfriend() != null){
                return boy.getGirlfriend().getName();
            }
        }
        return null;
    }

    /**
     * 使用Optional 优化 getGirlFriendName 避免出现空指针
     */
    public String getGirlFriendName2(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //此时boy2一定非空
        Boy boy2 = boy1.orElse(new Boy(new Girl("小花")));
        Girl girlfriend = boy2.getGirlfriend();
        //此时girlfriend1一定非空
        Optional<Girl> girlfriend1 = Optional.ofNullable(girlfriend);
        Girl girl = girlfriend1.orElse(new Girl("小芳"));
        return girl.getName();

    }
}
