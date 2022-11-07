package com.atxiao2._07_reflection._02_class_loader_test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : XiaoEr
 * @date : 2022/10/27
 *
 * 类的加载器：用来把类（class）装在进内存
 *      |--Bootstrap ClassLoader（引导加载器：用来装载jvn带的核心类库，无法直接获取和加载自定义内）
 *          |--Extension ClassLoader（扩展加载器： 用来加载lib下的jre包）
 *              |--System ClassLoader(系统加载器：最常用的加载器，可以加载自定义类)
 *
 *
 */
public class ClassLoaderTest {

    @Test
    public void test(){
        //获取自定义类的系统类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);

        //调用classloader的getParent（）获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println("classLoader1 = " + classLoader1);

        //引导类加载器无法直接获取
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println("classLoader2 = " + classLoader2);//null
    }

    /**
     * 类加载器的应用之一：
     *    加载配置文件properties
     */
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        //方式一：使用流加载
        // FileInputStream fileInputStream = new FileInputStream("resource/properties_test.properties");
        // properties.load(fileInputStream);

        //方式二：使用类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //getResourceAsStream()会默认去resource下去找，没找到会找src下
        InputStream resourceAsStream = classLoader.getResourceAsStream("properties_test.properties");
        properties.load(resourceAsStream);

        String user = properties.getProperty("name");
        System.out.println("name = " + user);

        String password = properties.getProperty("password");
        System.out.println("password = " + password);

    }
}
