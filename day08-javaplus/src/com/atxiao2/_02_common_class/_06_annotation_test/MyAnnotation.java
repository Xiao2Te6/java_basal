package com.atxiao2._02_common_class._06_annotation_test;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author : XiaoEr
 * @date : 2022/7/18
 */
//    类/接口/枚举， 字段（属性），方法， 参数， 构造器，局部变量，module模块
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)

@Documented  //将被javadoc文档解析保留
@Inherited //MyAnnotation 目标的子类会继承该注解

@Repeatable(MyAnnotations.class) //java8特性 ，可重复注解

public @interface MyAnnotation {

    //属性 String类型名叫value的变量 默认值为 "hello"
    String value() default "hello";

    
}
