package com.atxiao2._02_common_class._04_other_class_test;

import org.junit.Test;

/**
 * System类常用方法
 *   getProperty()
 */
public class SystemTest {
    @Test
    public void test(){
        //获取java版本
        String version = System.getProperty("java.version");
        System.out.println("version = " + version);

        //获取java路径
        String home = System.getProperty("java.home");
        System.out.println("home = " + home);

        // 获取系统的名称
        String osName = System.getProperty("os.name");
        System.out.println("osName = " + osName);

        //获取系统的版本
        String  osVersion = System.getProperty("os.version");
        System.out.println("osVersion = " + osVersion);

        //获取用户名
        String  userName = System.getProperty("user.name");
        System.out.println("userName = " + userName);

        //获取用户路径
        String userHome = System.getProperty("user.dir");
        System.out.println("userHome = " + userHome);

        //获取用户文件夹(当前项目文件夹)
        String userDir = System.getProperty("user.dir");
        System.out.println("userDir = " + userDir);
    }
}
