package com.atxiao2._08_java8_new_features._03_reference;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : XiaoEr
 * @date : 2022/11/3
 *
 * 构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的新参列表一致，抽象方法的返回值类型为构造器所属的类
 *
 * 数组引用
 *      一种特殊的构造器引用
 */
public class ConstructorReference {

    /**
     * 需求： 使用构造器引用获取一个Employee对象
     *      Supplier 中 T get()  引用无参构造器
     */
    @Test
    public void test(){

        Supplier<Employee> supplier = () -> new Employee();
        System.out.println("构造器引用前" + supplier.get());

        System.out.println("*********************");

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println("构造器引用后" + supplier.get());
    }

    /**
     * 需求： 使用构造器引用获取一个Employee对象
     *      Function 中 R apply(T t)  引用一个参数的构造器
     */
    @Test
    public void test2(){

        Function<String, Employee> function = e -> new Employee(e);
        System.out.println("构造器引用前" + function.apply("小黄"));

        System.out.println("*********************");

        Function<String, Employee> function1 = Employee :: new;
        System.out.println("构造器引用后" + function1.apply("小白"));
    }

    /**
     * 需求： 使用构造器引用获取一个Employee对象
     *      BiFunction 中 R apply(T t1, T t2)  引用两个参数的构造器
     */
    @Test
    public void test3(){

        BiFunction<String, Integer, Employee> function = (name, age) -> new Employee(name,age);
        System.out.println("构造器引用前" + function.apply("小黄",18));

        System.out.println("*********************");

        BiFunction<String, Integer, Employee> function1 = Employee :: new;
        System.out.println("构造器引用后" + function1.apply("小白",17));
    }

    /**
     * 数组引用
     *   Function 中的 R apply(T t) 返回一个动态定义的数组
     */
    @Test
    public void test4(){
        Function<Integer, String[]> function = i -> new String[i];
        System.out.println("数组引用前：" + Arrays.toString(function.apply(3)));

        System.out.println("***********************");

        Function<Integer, String[]> function1 = String[]::new;
        System.out.println("数组引用后：" + Arrays.toString(function1.apply(4)));

    }
}
