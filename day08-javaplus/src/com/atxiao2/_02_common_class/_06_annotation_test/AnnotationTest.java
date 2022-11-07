package com.atxiao2._02_common_class._06_annotation_test;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : XiaoEr
 * @date : 2022/7/18
 *
 * Annotation (注解）    JDK5.0新增
 *      Annotation 就是代码里的 特殊标记，这些标记可以在类编译、加载、运行时被读取
 *        并执行响应处理。可以在不改变原理的情况下在源文件中嵌入一些补充信息，开发工具
 *        和部署工具可以通过这些补充信息对代码进行校验或者进行部署
 *
 *      示例一：生成文档相关的注解 如@author等
 *      示例二：JDK内置的三个基本注解
 *          @Overried： 限定重写父类方法
 *          @Deprecated： 标示所修饰的元素已经过时，通常是因为所修饰的结构危险或有更好的选择
 *          @SupperssWarnings: 编译器抑制警告 （贴上这个注解，编译器将不会再提示警告）
 *      示例三：跟踪代码依赖性，实现替代配置文件功能
 * 自定义注解：
 *          用 @interface 声明
 *          内部定义成员变量（以无参数方法的形式来声明，方法名和返回值类型表示该成员变量的名字和类型），通常用value表示 可以使用default来定义成员的默认值
 *          如果自定义注解中没有成员，表明是一个标示作用 （Serializable接口没有方法，也是一个标示作用接口）
 *
 *      如果注解有成员，在使用注解时，需要指明成员的值
 *      自定义注解必须配上注解的信息处理流程才有意义
 *      自定义注解一般都会声明两个元注解（@Retention 和 @Target）
 *
 * JDK提供的4个元注解： 对现有的注解进行解释说明的注解
 *              //比较常用
 *             Retention 指明修饰的Annotation的生命周期
 *                      SOURCE 编译时就不加载
 *                      CLASS 保留到编译时候，运行时不加载 （默认行为）
 *                      RUNTIME 保留到运行时，并会加载到注解中 （只有声明为RUNTIME的注解才能通过反射拿到）
 *             Target 限制注解能修饰的结构
 *              //使用较少
 *             Documented 修饰的注解在javadoc文档解析时，保留下来
 *             Inherited  被修饰的注解具有继承性，（当一个类贴上有Inherited修饰的注解时，子类也会继承该注解，默认贴上该注解）
 *
 * 通过反射获取注解信息
 *
 *
 * jdk8中关于注解的新特性
 *          可重复注解： 在MyAnnotation上使用@Repeatable注解属性为 MyAnnotations.class
 *                     该注解value值为 MyAnnotation[] ，元注解要和MyAnnotation保持一致
 *                   当需要重复使用该注解时，会自动将两个或多个注解封装到定义的MyAnnotations 注解的value中
 *
 *          类型注解： ElementType.TYPE_PARAMETER 表示该注解能声明在变量类型的声明语句中（如泛型）
 *                   ElementType.TYPE_USE 表示该注解能声明在使用任何类型语句中
 *
 */

//jdk8 前的写法
// @MyAnnotations({@MyAnnotation("he"), @MyAnnotation("her")})

//jdk8 后的重复注解写法，会通过Repeatable注解找到定义的MyAnnotations注解，并默认使用该注解
@MyAnnotation("he")
@MyAnnotation("her")
public class AnnotationTest {

    @MyAnnotation(value = "hi")
    private int age;

    public static void main(String[] args) {

        //Inherited元注解作用，Person的MyAnnotation注解被Student继承
        for (Annotation annotation : Student.class.getAnnotations()) {
            System.out.println(annotation);//@com.atxiao2._02_common_class._06_annocation_test.MyAnnotation(value="hello")
        }
    }

    /**
     * 类型注解 ElementType.TYPE_USE
     */
    @Test
    public void test01 () throws @MyAnnotation Exception{

        List<@MyAnnotation String > arr = new ArrayList<>();

        int  a  = (@MyAnnotation int)1l;
    }

}

@MyAnnotation
class Person{

    @Override
    public String toString() {
        System.out.println("我是一个人");
        return "Person";
    }

}
            //类型注解 ElementType.TYPE_PARAMETER
class Student <@MyAnnotation T> extends Person{

    @SuppressWarnings("all") //抑制所有警告
    String nameeeee;

    String namee;

}
