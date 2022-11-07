package com.atxiao2._07_reflection._04_get_class_stracture;

import com.atxiao2._07_reflection._04_get_class_stracture.person.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author : XiaoEr
 * @date : 2022/10/31
 *
 * 获取运行时类中的方法
 *
 * Annotation
 * Modifier Return Name(Parameters) Exception
 *
 */
public class GetMethodsTest {


    @Test
    public void test(){
        Class<Person> clazz = Person.class;
        //方式一 getMethods():获取当前运行时类及其父类中的所有public的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("m = " + m);
        }
        System.out.println();
        //方式二 getDeclaredMethods()：获取当前运行时类的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method dm : declaredMethods) {
            System.out.println("dm = " + dm);
        }
    }

    /**
     * 获取运行时类中的结构
     *
     *  方法注解 权限修饰符 返回值类型 方法名 （参数列表） 异常
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            //获取方法注解 getAnnotations()
            Annotation[] annotations = m.getAnnotations();
            if (annotations.length > 0){
                for (Annotation annotation : annotations) {
                    System.out.println("annotation = " + annotation);
                }
            }
            //获取权限修饰符 getModifiers（）
            int modifiers = m.getModifiers();
            System.out.println("modifiers = " + Modifier.toString(modifiers));

            //获取返回值类型 getReturnType()
            Class<?> returnType = m.getReturnType();
            System.out.println("returnType = " + returnType);

            //获取方法名 getName()
            String name = m.getName();
            System.out.println("name = " + name);

            //获取参数列表 getParameterTypes()
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (parameterTypes.length > 0){
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("parameterType = " + parameterType);
                }
            }

            //获取方法抛出异常: getExceptionTypes()
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0){
                for (Class<?> exceptionType : exceptionTypes) {
                    System.out.println("exceptionType = " + exceptionType);
                }
            }

            System.out.println();
        }
    }
}
