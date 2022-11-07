package com.atxiao2._08_java8_new_features._04_stream_api;

import com.atxiao2._08_java8_new_features._03_reference.Employee;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : XiaoEr
 * @date : 2022/11/4
 *
 * Stream API 终止操作
 *
 */
public class StreamAPITest3 {
    /**
     * 终止操作之 查找与匹配
     *      allMatch(Prediction p) : 判断是否全部匹配
     *      anyMatch(Prediction p) ：判断是否有一个匹配
     *      noneMatch(Prediction p)： 判断是否没有一个匹配
     *      findFirst(): 返回流中第一个元素
     *      count()：返回流中元素个数
     *      max(Comparator c)： 返回流中最大的元素
     *      min(Comparator c)： 返回流中最小的元素
     *      forEach(Consumer c) ： 内部迭代
     */
    @Test
    public void test(){
        List<Employee> employees = StreamAPITest2.getEmployees();

        //allMatch(Predicate p) 判断流中元素是否全部匹配
        // 年龄全大于10？
        boolean a = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println(a + "\n");
        //anyMatch(Predicate p) 判断流中元素是否至少匹配一个
        // 是否有年龄大于10的？
        boolean b = employees.stream().anyMatch(e -> e.getAge() > 10);
        System.out.println(b + "\n");
        //noneMatch(Predicate p) 判断流中元素是否全都不匹配
        // 是否全部年龄都大于30？
        boolean c = employees.stream().noneMatch(e -> e.getAge() > 30);
        System.out.println(c + "\n");

        //findFirst() 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println("first = " + first);

        //count() 返回流中元素个数
        long count = employees.stream().count();
        System.out.println("count = " + count);

        //max(Comparator c) 返回最大值（排序后最后一个元素）
        //返回员工年龄最大的
        Optional<Employee> max = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("max = " + max);
        //min(Comparator c) 返回最小（排序后第一个一个元素）
        //返回年龄最小的员工
        Optional<Employee> min = employees.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println("min = " + min);

        //forEach(Consumer c)  内部迭代（和iterator外部迭代作用类似）
        employees.stream().forEach(System.out::println);
    }

    /**
     * 终止操作之 归约
     *      reduce(T identity, BinaryOperator b) 将流中的元素从 identity 开始依次进行 b 操作。
     *      reduce(BinaryOperator b) 将流中元素依次进行b操作
     */
    @Test
    public void test2(){
        //reduce()
        //计算1到10的和加10
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(10, Integer::sum);
        System.out.println("reduce = " + reduce);
        //计算所有员工年龄和
        List<Employee> employees = StreamAPITest2.getEmployees();
        Optional<Integer> reduce1 = employees.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println("reduce1 = " + reduce1);

    }

    /**
     * 终止操作之 搜集
     *      collect(Collector c)将流中的元素搜集到Collection中（如搜集到List,Set,Map中）
     */
    @Test
    public void test3(){
        //查找年龄小于18的员工，并返回一个List(Collectors.toList(), Set Collectors.toSet())
        List<Employee> employees = StreamAPITest2.getEmployees();
        List<Employee> list = employees.stream().filter(s -> s.getAge() < 18).collect(Collectors.toList());
        System.out.println(list);
    }
}
