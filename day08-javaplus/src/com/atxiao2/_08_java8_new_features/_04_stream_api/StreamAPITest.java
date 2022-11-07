package com.atxiao2._08_java8_new_features._04_stream_api;

import com.atxiao2._08_java8_new_features._03_reference.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : XiaoEr
 * @date : 2022/11/3
 *
 * Stream API
 *         对集合数据进行计算等相关操作
 *     特点：
 *          Stream 自己不会存储元素
 *          Stream 不会改变源对象，他们会返回一个持有新结果的Stream
 *          Stream 操作是有延迟性的，需要等到终结操作才会执行
 *     操作步骤：
 *          创建Stream流
 *
 *          中间操作（一个中间操作链，对数据源的数据进行处理）
 *
 *          终止操作（一旦执行终止操作，就执行中间操作并返回结果，之后就不会再被使用）
 *
 *   创建Stream流的方式
 */
public class StreamAPITest {

    /**
     * 方式一：通过集合
     */
    @Test
    public void test(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1001L,"小黄", 18));
        employees.add(new Employee(1002L,"小白", 17));
        employees.add(new Employee(1003L,"小黑", 21));
        employees.add(new Employee(1004L,"小蓝", 19));

        // 使用stream()返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // 使用parallelStream() 返回一个并行流
        Stream<Employee> stream1 = employees.parallelStream();
    }

    /**
     * 方式二： 通过数组
     */
    @Test
    public void test2(){
        //通过 Arrays.stream( T[] arr) 返回一个流
        IntStream stream = Arrays.stream(new int[]{1, 3, 4, 5, 7});
    }

    /**
     * 方法三： 通过Stream的 of()
     */
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);

    }

    /**
     *  方法四： 创建无线流
     */
    @Test
    public void test4(){

        //迭代 static iterate(final T seed, final UnaryOperator<T> f)(种子（基数） Function的子接口，T apply(T t))
        //遍历前10个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

        //生成 static Stream generate(Supplier<T> s)
        //生成3个随机数
        Stream.generate(Math::random).limit(3).forEach(System.out::println);

    }
}
