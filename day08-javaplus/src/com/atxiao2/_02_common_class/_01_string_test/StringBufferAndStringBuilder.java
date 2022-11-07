package com.atxiao2._02_common_class._01_string_test;

import org.junit.Test;

/**
 * String：不可变的字符序列，
 * StringBuffer： 可变的字符序列，线程安全但效率较低
 * StringBuilder： 可变的字符序列，线程不安全但效率较高
 *
 *  String、StringBuffer、StringBuilder 底层都是用的char型数组存储
 *
 *  String每次修改字符串底层都会新建一个char[]
 *  StringBuffer和StringBuilder会默认声明一个char[16]来存放字符串，再根据情况扩容（一般默认扩容两倍） 类似于ArrayList
 *
 *  效率对比： StringBuilder > Str/ingBuffer > String
 *
 *  常用方法：（StringBuffer和StringBuilder方法名一样）
 *      StringBuilder append(String str) 添加字符串 （可以链式调用）
 *      StringBuilder delete(int startIndex， int endIndex) 删除指定位置内容
 *      StringBuilder replace（int startIndex， int endIndex，string str）把[star, end)位置内容替换成str
 *      StringBuilder insert（int offset， String str）再指定位置插入
 *      StringBuilder reverse（） 将当前字符序列翻转
 *      int indexOf（String str） 获取对应支付串位置
 *      String substring（int start， int end） 截取指定位置字符串
 *      int length（）获取长度
 *      char charAt（int index） 获取对应位置字符
 *      void setCharAt（int index， char c） 修改指定位置字符串
 *
 *
 */
public class     StringBufferAndStringBuilder {
    @Test
    public void test(){
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb);
        // 增
        sb.append("def");
        System.out.println(sb);
        // 删
        sb.delete(5,6);
        System.out.println(sb);
        // 改
        sb.replace(4,5,"gh");
        // sb.setCharAt(2, 'h')
        System.out.println(sb);
        // 插
        sb.insert(0,6);
        System.out.println(sb);
        //反转
        sb.reverse();
        System.out.println(sb);
        //截取
        System.out.println(sb.substring(5, 7));
        //查
        sb.charAt(3);
    }
}
