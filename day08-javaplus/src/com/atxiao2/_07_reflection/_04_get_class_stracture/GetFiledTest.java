package com.atxiao2._07_reflection._04_get_class_stracture;

import com.atxiao2._07_reflection._04_get_class_stracture.person.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author : XiaoEr
 * @date : 2022/10/31
 *
 * 获取当前运行时类中的所有属性
 */
public class GetFiledTest {

    /**
     * 获取当前运行时类的属性（字段/成员变量 ）
     */
    @Test
    public void test(){
        Class<Person> clazz = Person.class;

        //方式一：getFields():获取当前运行时类及其父类中所有public的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        //方式二：getDeclaredFields():获取当前运行时类的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field df : declaredFields) {
            System.out.println(df);
        }
    }

    /**
     * 获取属性名，类型，修饰符
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] df = clazz.getDeclaredFields();
        for (Field field : df) {
            //getModifiers(): 获取属性修饰符类型返回Modifier类中的常量（public为1 ，privat为2，default为0）
            int modifiers = field.getModifiers();
            System.out.println("modifiers = " + Modifier.toString(modifiers));

            //getType（）：获取属性类型
            Class<?> type = field.getType();
            System.out.println("type = " + type.getName());

            //getName():获取属性名
            String name = field.getName();
            System.out.println("name = " + name);

            System.out.println();
        }
    }
}
