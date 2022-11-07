package com.atxiao2._08_java8_new_features._04_stream_api;

import com.atxiao2._08_java8_new_features._03_reference.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : XiaoEr
 * @date : 2022/11/4
 *
 * StreamAPI中间操作
 *          过滤、截断、跳过、筛选
 *          映射
 *          排序
 */
public class StreamAPITest2 {

    /**
     * 中间操作之 过滤、截断、跳过、筛选
     */
    @Test
    public void test(){
        List<Employee> employees = getEmployees();

        //过滤 filter(Predicate p) 从流中排除不符合条件的元素
        //排除员工中年龄大于18的
        employees.stream().filter(e -> e.getAge() < 18).forEach(System.out::println);
        System.out.println();
        //截断 limit(n)  使流中的个数不超过n个
        //只显示流中前三个元素
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //跳过 skip(n) 跳过流中前n个元素
        //跳过流中前三个元素
        employees.stream().skip(3).forEach(System.out::println);
        // employees.stream().skip(30).forEach(System.out::println); //跳过完了会显示空流
        System.out.println();

        //筛选 distinct() 通过流中元素的hashCode()和equals()去除流中重复元素
        employees.stream().distinct().forEach(System.out::println);
    }

    /**
     * 中间操作之 映射
     *   map()
     *   flatmap()
     */
    @Test
    public void test2(){
        List<String> strings = Arrays.asList("AA", "BB", "CC", "DD", "EE", "FF");
        //map(Function f) 对流中每个元素进行操作
        strings.stream().map(String::toLowerCase).forEach(System.out::println);
        System.out.println();
        //练习获取员工年龄大于30的员工的年龄
        getEmployees().stream().filter(e -> e.getAge() > 30).map(Employee::getAge).forEach(System.out::println);
        System.out.println();

        // flatmap(Function f) 使用该方法流里面不会再嵌套流，会自动展开成一维流
        // strings.stream().map(s -> getStream(s)); //此时流里面为一Stream，这个流为一个二维Stream
        strings.stream().flatMap(s -> getStream(s))//此时流里为character，是一个一维流
                .forEach(System.out::println);
    }

    /**
     * 中间操作之 排序
     *  sorted() 自然排序
     *  sorted(Comparator c) 定制排序
     */
    @Test
    public void test3(){
        //sorted()自然排序
        List<Employee> employees = getEmployees();
        employees.stream().sorted().forEach(System.out::println);
        System.out.println();

        //sorted(Comparator c) 定制排序
        //按年龄从大到小排列并，在按照姓名排列
        employees.stream().sorted((e1, e2) -> {
            int compare = Integer.compare(e2.getAge(), e1.getAge());
            if (compare == 0){
                return e1.getName().compareTo(e2.getName());
            }
            return compare;
        }).forEach(System.out::println);
    }

    /**
     * 返回一个Stream
     */
    public static Stream<Character> getStream(String s){
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }


    /**
     * 返回一个员工list
     * @return
     */
    public static List<Employee>  getEmployees(){
        return Arrays.asList(new Employee(1001L, "小黄", 18),
                new Employee(1002L, "小蓝", 19),
                new Employee(1003L, "小绿", 17),
                new Employee(1004L, "小紫", 20),
                new Employee(1005L, "小黑", 25),
                new Employee(1006L, "小青", 50),
                new Employee(1007L, "小橙", 49),
                new Employee(1008L, "小灰", 12),
                new Employee(1008L, "小灰", 12),
                new Employee(1008L, "小灰", 15),
                new Employee(1008L, "小灰2", 12),
                new Employee(1008L, "小灰", 12),
                new Employee(1009L, "小彩", 33));
    }
}
