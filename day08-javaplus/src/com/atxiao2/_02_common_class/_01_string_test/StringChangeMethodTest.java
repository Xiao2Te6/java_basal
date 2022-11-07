package com.atxiao2._02_common_class._01_string_test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String转换为基本数据类型或者包装类
 * 对应包装类.parseXxx()  或者 对应包装类.valueOf();
 * 包装类转 String ，直接调用String得value Of（）方法；
 * <p>
 * String 和 char[] 之间得转换
 * String --> char[] 调用String的toCharArray()方法
 * char[] --> String 调用String的构造器
 * <p>
 * String 和 byte[] 之间的转换
 * String --> byte[] 调用String的getBytes()方法
 * byte[] --> String 嗲用String的构造器
 */
public class StringChangeMethodTest {

    @Test //String --> 包装类
    public void test() {
        String str = "123";
        System.out.println(Integer.parseInt(str));
        System.out.println(Integer.valueOf(str));
    }

    @Test //String --> char[]
    public void test02() {
        String str = "abcdefg";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }
    }

    @Test // char[] --> String
    public void test03() {
        char[] c = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s = new String(c);
        System.out.println(s);
    }

    @Test // String --> byte[] 编码过程
    public void test04() throws UnsupportedEncodingException {
        //常规的字母数字和符号会转换为ASCLl码
        String str = "abc123";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        //带中文的字符串转换为byte[]时会根据getBytes()方法中传入的参数而定
        String str2 = "abc123中国";
        byte[] bytes1 = str2.getBytes();//不传入参数转换为默认编码（当前编译环境编码utf-8）
        System.out.println(Arrays.toString(bytes1));

        byte[] gbks = str2.getBytes("gbk");//转换为对应编码集
        System.out.println(Arrays.toString(gbks));

        /*小tips：utf-8涵盖所有符号和语言，在utf-8中一个中文符号占3个字节
                  而gbk中只包含中文，一个中文字符占两个字节 ，所以有时同样的内容gbk编码大小会小一些*/
    }

    @Test //byte[] --> String  解码过程(解码使用字符集要和编码一致)
    public void test05() throws UnsupportedEncodingException {
        byte[] b = new byte[]{97, 43, 67, 55, 100};
        System.out.println(new String(b));

        byte[] utf8s = new byte[]{97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67};
        byte[] gbks = new byte[]{97, 98, 99, 49, 50, 51, -42, -48, -71, -6};

        System.out.println(new String(utf8s)); //没有指定编码，使用默认编码集
        System.out.println(new String(gbks)); // 默认编码集为utf-8 编码不匹配出现乱码

        System.out.println(new String(gbks, "gbk")); //指定正确编码集，乱码消失

    }
}
