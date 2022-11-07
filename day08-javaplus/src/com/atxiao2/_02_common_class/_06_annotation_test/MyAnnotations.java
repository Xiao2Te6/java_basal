package com.atxiao2._02_common_class._06_annotation_test;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author : XiaoEr
 * @date : 2022/8/3
 *
 * MyAnnotations
 * MyAnnotation的可重复注解
 *      该注解value值为 MyAnnotation[] ，元注解要和MyAnnotation保持一致，方法名要相同
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotations {

    MyAnnotation[] value();
}
