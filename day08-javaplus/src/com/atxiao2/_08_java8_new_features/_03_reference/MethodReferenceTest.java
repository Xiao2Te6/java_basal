package com.atxiao2._08_java8_new_features._03_reference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : XiaoEr
 * @date : 2022/11/2
 *
 * 方法引用：本质上还是lambda表达式，也是函数式接口的实例 （将lambda体引 用为相同功能的方法，对象（或则类）.方法 （） ） 
 *      使用情景：当需要写的lambda体的操作已经有实现的方法了，就可以使用方法引用
 *
 *      使用格式：类（或对象名）:: 方法名 
 *
 *      使用情况（3种）：
 *          对象 :: 非静态方法
 *           类 :: 静态方法
 *       （以上两种方法要求接口中的抽象方法的形参列表和返回值与引用方法的形参列表和返回值相同）
 *
 *           类 ::  非静态方法
 *        （此种情况适用于，引用方法参数个数比抽象方法参数多一时（抽象1个，引用2个或者抽象没有，引用有1个），且多的参数作为方法的调用者，此参数可以用所在类作为引用左边 ）
 *
 */
public class MethodReferenceTest {

    /**
     *  对象 :: 非静态方法  示例：
     *    Consumer 中 void accept(T t)
     *              ⬇⬇
     *    PrintStream 中 void println(T t)
     */
    @Test
    public void test1(){
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("方法引用前");

        System.out.println("********************");

        PrintStream out = System.out;
        Consumer<String> consumer2 = out::println;
        consumer2.accept("方法引用后");
    }

    /**
     *  对象 :: 非静态方法  示例2：
     *    Supplier 中 T get()
     *              ⬇⬇
     *    Employee 中 String getName()
     */
    @Test
    public void test2(){

        Employee employee = new Employee("小黄", 18);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println("方法引用前" + supplier.get());

        System.out.println("********************");

        Supplier<String> supplier1 = employee::getName;
        System.out.println("方法引用后" + supplier.get());
    }

    /**
     *    类 :: 静态方法  示例1
     *    Comparator 中 int compare(T t1, T t2)
     *              ⬇⬇
     *    Integer 中 int compare(T t1, T t2)
     */
    @Test
    public void test3(){
        Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1,t2);
        System.out.println("方法引用前：" + comparator.compare(5,13));

        System.out.println("*******************");

        Comparator<Integer> comparator1 = Integer :: compare;
        System.out.println("方法引用后" + comparator1.compare(5,13));
    }

    /**
     *    类 :: 静态方法  示例2
     *    Function 中 R apply(T t)
     *              ⬇⬇
     *    Math 中 Long round(T t)
     */
    @Test
    public void test4(){
        Function<Double,Long> function = d -> Math.round(d);
        System.out.println("方法引用前：" + function.apply(5.6));

        System.out.println("*******************");

        Function<Double,Long> function1 = Math::round;
        System.out.println("方法引用后" + function1.apply(5.4));
    }


    /**
     *    类 :: 非静态方法  示例1: 用第一个调用参数所在的类 代替 该参数
     *    Comparator 中 int compare(T t1, T t2)
     *              ⬇⬇
     *    String 中  t1.compareTo(t2)
     */
    @Test
    public void test5(){
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println("方法引用前：" + comparator.compare("s", "d"));

        System.out.println("*******************");

        Comparator<String> comparator1 = String :: compareTo;
        System.out.println("方法引用后" + comparator1.compare("s", "d"));
    }

    /**
     *    类 :: 非静态方法  示例2: 用第一个调用参数所在的类 代替 该参数
     *    BiPredicate 中 boolean test(T t1, T t2)
     *              ⬇⬇
     *    String 中  boolean t1.equals(t2)
     */
    @Test
    public void test6(){
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println("方法引用前：" + predicate.test("s", "d"));

        System.out.println("*******************");

        BiPredicate<String, String> predicate2 = String :: equals;
        System.out.println("方法引用后" + predicate2.test("s", "d"));
    }

    /**
     *    类 :: 非静态方法  示例2: 用第一个调用参数所在的类 代替 该参数
     *    Function<T, R> 中  R  apply(T t)
     *              ⬇⬇
     *    Employee 中  String getName()
     */
    @Test
    public void test7(){
        Employee employee = new Employee();
        employee.setName("小黄");

        Function<Employee,String> function = e -> e.getName();
        System.out.println("方法引用前：" + function.apply(employee));

        System.out.println("*******************");

        Function<Employee,String> function2 = Employee :: getName;
        System.out.println("方法引用后" + function2.apply(employee));
    }
}
