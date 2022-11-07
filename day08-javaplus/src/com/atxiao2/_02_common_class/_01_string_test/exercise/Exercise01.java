package com.atxiao2._02_common_class._01_string_test.exercise;

/**
 * 将一个字符串指定位置部分进行反转 如”abcdefg“反转为”abfedcg“
 */
public class Exercise01 {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse(str, 2,6));


    }

    // 方法一
    public static String reverse(String str, int start, int end) {
        if( str != null){
            String substring = str.substring(start, end); // 截取
            StringBuilder stringBuilder = new StringBuilder(substring.length()); //转换成StringBuilder
            stringBuilder.append(substring).reverse(); // 反转
            return str.replace(substring, stringBuilder.toString());// 替换并返回
        }
        return null;
    }

    //方法二 转换为char[]
    public static String reverse02(String str, int start, int end){
        if (str != null){
            char[] chars = str.toCharArray();
            for (int i = start, j = end; i < j ; i++, j--){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
        return null;
    }
}
