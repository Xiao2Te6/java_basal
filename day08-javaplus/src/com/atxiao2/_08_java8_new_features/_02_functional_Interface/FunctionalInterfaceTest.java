package com.atxiao2._08_java8_new_features._02_functional_Interface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author : XiaoEr
 * @date : 2022/11/2
 *
 *  函数式接口：只包含一个抽象方法的接口
 *      java内置的四大函数式接口：
 *          消费型接口：Consumer<T>    void accept(T t) 对T类型对象进行操作
 *          供给型接口：Supplier<T>    T get()    返回T对象的操作
 *          函数型接口：Function<T,R>  R apply(T t) 对T类型对象进行操作并返回R类型的对象的结果。
 *          判定型接口：Predicate<T>   boolean  (T t) 对T类型对象进行判定，并返回boolean类型的结果
 */
public class FunctionalInterfaceTest {

    /**
     * 消费型接口
     */
    @Test
    public void test1(){
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("这是消费型接口");
    }

    /**
     * 供给型接口
     */
    @Test
    public void test2(){
        Supplier<String> supplier = () -> "这是一个供给型接口";
        System.out.println(supplier.get());
    }

    /**
     * 函数型接口
     *      需求：将字符数组转换成字符串
     */
    @Test
    public void test3(){
        Function<char[], String> function = s -> new String(s);
        System.out.println(function.apply(new char[]{'a', 'b', 'c', 'd', 'e'}));
    }

    /**
     * 判定型接口
     *      需求：判断传入字符串是否包含"y"
     */
    @Test
    public void test4(){
        Predicate<String> predicate = s -> s.contains("y");
        System.out.println(predicate.test("qwertyu"));
    }

}
