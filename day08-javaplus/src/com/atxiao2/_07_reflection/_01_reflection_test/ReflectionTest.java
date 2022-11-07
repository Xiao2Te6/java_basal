package com.atxiao2._07_reflection._01_reflection_test;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author : XiaoEr
 * @date : 2022/10/8
 *
 * Reflection(反射)： 反射是被视为动态语言的关键，反射机制允许程序在执行期系借助Reflection API取得任何类的内部信息，
 *                  并能直接操作任意对象的内部属性及方法
 *
 *  java.lang.Class类：java中对类定义的类，Java中定义的类本身就是Class的对像
 *      类的加载：程序经过javac过后会生成一个或多个字节码文件（.class文件），接着使用java命令对字节码文件解释运行时相当于将这个字节码文件加载到内存中了。
 *          加载到内存中的类，称为运行时类，这个运行时类就是Class类的一个实例（Class类的实例就对应着一个运行时类）
 *          加载到内存中的运行时类会缓存一定的时间，在此时间之内，可以通过不同的方式去获取此运行时类（此运行时类对应Class实例）
 */
public class ReflectionTest {

    /**
     * 反射的演示
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Class<Person> personClass = Person.class;
        //通过反射拿到Person的私有构造器对象，并创建创建Person对象
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        // ConstructorReference<Person> constructor = personClass.getConstructor(); //获取公共无参构造器的对象
        declaredConstructor.setAccessible(true);
        Person person = declaredConstructor.newInstance("小明", 18);
        System.out.println(person);

        //调用私有方法
        Method show = personClass.getDeclaredMethod("show");
        show.setAccessible(true);
        System.out.println(show.invoke(person));
    }

    /**
     *  获取Class类实例的方法
     */
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一：类名.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //方式二：通过类的对象
        Person person = new Person();
        Class<? extends Person> personClass1 = person.getClass();
        System.out.println(personClass1);

        //方式三：调用Class类的静态方法 forName(String classPath)
        Class<?> personClass2 = Class.forName("com.atxiao2._07_reflection._01_reflection_test.Person");
        System.out.println(personClass2);

        //三种获取方式获取的是同一个运行时类对象
        System.out.println(personClass == personClass1); //true
        System.out.println(personClass1 == personClass2); //true

        //方式四：使用类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> personClass3 = classLoader.loadClass("com.atxiao2._07_reflection._01_reflection_test.Person");
        System.out.println(personClass3);
    }

    /**
     *Class实例类型
     *      Class实例的类型可以注是解、枚举类、抽象类、接口、基本数据类型类、数组类
     *      类的加载过程： 加载 ---> 链接 ---> 初始化
     */
    @Test
    public void test2(){

        Class<Test> testClass = Test.class;
        Class<Void> voidClass = void.class;
        Class<Integer> integerClass = int.class;
        Class<int[][]> aClass = int[][].class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<ElementType> elementTypeClass = ElementType.class;
        Class<Class> classClass = Class.class;

    }
}
