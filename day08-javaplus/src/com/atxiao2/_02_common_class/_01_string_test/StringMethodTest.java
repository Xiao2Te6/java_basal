package com.atxiao2._02_common_class._01_string_test;

import org.junit.Test;

import java.util.Arrays;

/**
 * （test）
 *  int length():  查询字符串长度，返回字符串的长度
 *  char charAt(int index): 获取某所应位置字符
 *  boolean isEmpty(): 判断字符串是否为空
 *  String toLowerCase():使用默认语言环境，将字符串转换成小写
 *  String toUpperCase():...... 将字符串转换成大写
 *  String trim(): 忽略字符串前后空白，返回字符串
 *
 *  (test2)
 *  boolean equals(Object obj): 比较字符串内容是否相等
 *  boolean equalsIgnoreCase（Object obj）：忽略字符大小写比较内容是否相等
 *  String concat(): 连接字符串（等同于用 “+” ）
 *  int compareTo(String otherString): 比较两个字符串大小(转换成ASCLL码相减)
 *  Sting substing(int beginIndex): 返回一个新的字符串，从beginIndex开始截取，到最后；
 *  Sting substing(int beginIndedx, int endIndex): 返回一个新的字符串，从beginIndex开始到，endIndex结束（左闭右开）
 *
 *  (test3)
 *  boolean endsWith(String suffix): 判断是字符串否以指定后缀suffix结尾
 *  boolean startsWith(String prefix): 判断字符串是否以指定前缀prefix开始
 *  boolean startsWith(String prefix, int toffset): 判断字符串从指定索引位置toffset是否以指定前缀prefix开始;
 *  boolean contains(CharSequence s): 判断字符串是否包涵此字符序列
 *
 *  int indexOf(String str): 返回字符串中指定字符str第一次出现的索引
 *  int indexOf(String str，int fromIndex): 返回字符串从指定索引位置开始fromIndex，往后找指定字符str第一次出现的索引
 *  int lastIndexOf(String str):  返回指定字符串str在字符串最右边第一次出现的索引；
 *  int lastIndexOf(String str， int fromIndex):  返回指定字符串str在字符串从指定索引位置开始fromIndex往右搜索（指定位置截断） 出现的位置；
 *  indexOf（）从左往右找，lastIndexOf（）从右往左找，找不到都返回-1；
 *
 *  (test4)
 *  替换
 *  String replace（char oldChar, char newChar）: 用新的字符串 或字符newChar 将原有的字符串中所有旧字符oldChar 或字符串 全都替换并返回为一个新的字符串
 *  String replaceAll（String a， String b）：使用给定的replacement替换此字符串中所有匹配给正则表达式子的子字符串
 *  String replaceFirst（String a， String b）：使用给定的replacement替换此字符串匹配给正则表达式子的 第一个 子字符串
 *
 *  boolean matches（）：判读此支付串是否匹配给定的正则表达式；
 *  切分
 *  String split(String regex):  根据匹配的正则表达式切分此字符串，并返回一个String类型的数组
 *  String split(String regex, int limit): 根据匹配的正则表达式切分此字符串，最终不超过limit个，如果超过了，剩下的全部放在一个元素中，返回一个String类型的数组
 *
 */
public class StringMethodTest {
    @Test
    public void test(){
       String str = "HelloWorld";
       System.out.println(str.length());
       System.out.println(str.charAt(0));
       System.out.println(str.isEmpty());

       String s2 = str.toLowerCase();
       String s3 = s2.toUpperCase();
       System.out.println("toUpperCase-->"+s3);
       System.out.println("toLowerCase-->" + s2);
       System.out.println(str); //字符串的不可变性

       String s4 = "   hello   wo rl d  ";
       System.out.println(s4); //可以用在输入框注册等使用
       System.out.println(s4.trim());
   }

    @Test
    public void test2(){
       String s1 = "helloworld";
       String s2 = "HELLOWORLD";
       System.out.println(s1.equals(s2));
       System.out.println(s1.equalsIgnoreCase(s2));
       System.out.println(s1.concat(s2));

       System.out.println(s1.compareTo(s2));//涉及字符串排序

       String s3 = "王小二确实有一把刷子";
       System.out.println(s3);
       System.out.println(s3.substring(6));
       System.out.println(s3.substring(5,8));
   }

   @Test
   public void test3(){
       String s1 = "helloworld";
       System.out.println(s1.endsWith("ld"));
       System.out.println(s1.startsWith("hel"));
       System.out.println(s1.startsWith("llo", 2));
       System.out.println(s1.indexOf("ll"));
       System.out.println(s1.indexOf("ll",3));

       String s2 = "hellorworld";
       System.out.println(s1.lastIndexOf("or"));
       System.out.println(s1.lastIndexOf("or",6));

   }

   @Test
    public void test4(){
       String s1 = "小二他是真的帅！帅！帅！";
       System.out.println(s1.replace("帅","英俊"));
       System.out.println(s1.replace("帅！","英俊~"));

       String s2 = "123hello321243,wor2213ld";
       System.out.println(s2.replaceAll("\\d+",",").replaceAll(",",""));

       System.out.println(Arrays.toString(s1.split("")));

       String s3 = "0825-5934793";              //判断“0825-”+ 7~8位纯数字
       System.out.println(s3.matches("0825-\\d{7,8}"));

   }
}
