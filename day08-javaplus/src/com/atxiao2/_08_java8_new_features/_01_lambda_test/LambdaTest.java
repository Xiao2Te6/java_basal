package com.atxiao2._08_java8_new_features._01_lambda_test;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author : XiaoEr
 * @date : 2022/11/2
 *
 * lambda表达式的使用：
 *      举例：（o1,o2） -> Integer.compare(o1,o2);
 *
 *      格式：
 *          ->:lambda操作符 或 箭头操作符号
 *          左边 ->：lambda 形参列表（接口中抽象方法的形参列表）
 *          -> 右边：lambda体 （重写接口中抽象方法的方法体）
 *
 *      lambda表达式语法格式（6种情况）：
 *          左边 ->: lambda 形参列表参数类型可以省略（类型推断）；如果形参列表只有一个参数，参数外的小括号()可以省略
 *          -> 右边: lambda体 应该用一对大括号{}包裹；如果lambda体只有一条执行语句则可以省略这对大括号{}（若为return语句则return和大括号{}需一起省略）
 *
 *      lambda表达式的本质：lambda表达式就是函数式接口的实例（匿名内部类的简写）
 *           函数式接口：只包含一个抽象方法的接口 @FunctionalInterface注解可以验证是否是函数式接口
 */
public class LambdaTest {
    /**
     * 语法格式一：无参，无返回值
     */
    @Test
    public void test(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("原写法");
            }
        };
        runnable.run();
        System.out.println("************************");

        Runnable runnableForLambda = () -> {System.out.println("lambda写法");};
        runnableForLambda.run();
    }

    /**
     * 语法格式二：lambda需要一个参数无返回值
     */
    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("原写法");
        System.out.println("************************");

        Consumer<String> consumerForLambda = (String str) -> {System.out.println(str);};
        consumerForLambda.accept("lambda写法");
    }

    /**
     * 语法格式三：当接口有泛型时，参数数据类型可以省略（编译器可以推断得出，称为”类型推断“）
     */
    @Test
    public void test3(){
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("原写法");
        System.out.println("************************");

        Consumer<String> consumerForLambda = (s) -> {System.out.println(s);};
        consumerForLambda.accept("lambda写法");

    }

    /**
     * 语法格式四:  lambda 只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test4(){
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("原写法");
        System.out.println("************************");

        Consumer<String> consumerForLambda = s -> {System.out.println(s);};
        consumerForLambda.accept("lambda写法");
    }


    /**
     * 语法格式五：lambda 有两个以上的参数，多条执行语句，并且有返回值时
     */
    @Test
    public void test5(){
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("原写法");
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare("s", "A"));
        System.out.println("*********************");


        Comparator<String> comparatorForLambda = (o1,o2) -> {
            System.out.println("Lambda写法");
            return o1.compareTo(o2);
        };
        System.out.println(comparatorForLambda.compare("s", "A"));
    }

    /**
     * 语法格式六：lambda 体只有一条语句时，return和大括号可以一起省略
     */
    @Test
    public void test6(){
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("原写法：" + comparator.compare("s", "A"));
        System.out.println("*********************");


        Comparator<String> comparatorForLambda = (o1,o2) -> o1.compareTo(o2);
        System.out.println("Lambda写法：" + comparatorForLambda.compare("s", "A"));
    }
}
