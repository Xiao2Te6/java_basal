package com.atxiao2._05_io_stream._02_io_test._04_convert_stream_test;

import org.junit.Test;

import java.io.*;

/**
 * @author : XiaoEr
 * @date : 2022/10/1
 *
 * IO流 分类
 *      按照数据单位分：字节流（8bit byte）、字符流(16bit char 常用来处理txt文本)
 *      按照流的流向分： 输入流（从硬盘（文件）输入到程序（内存）中） 、 输出流（从程序（内存）输出到硬盘（文件）中）
 *      按照角色分： 节点流（程序直接操作文件的流） 、 处理流（作用于流，用来操作流的流）
 *
 * IO流常用类体系
 *      分类	    字节输入流	        字节输出流	            字符输入流	        字符输出流
 *     抽象基类	InputStream	        OutputStream	        Reader	            Writer
 *     文件节点流	FileInputStream	    FileOutputStream	    FileReader	        FileWriter
 *     缓冲流	BufferedInputStream	BufferedOutputStream	BufferedReader	    BufferedWriter
 *     转换流			                                    InputStreamReader	OutputStreamWriter
 *
 * IO流之转换流： 字符流、处理流，提供字节流和字符流之间的转换
 *      InputStreamReader(InStream, StringCode): 将字节流输入流转换为字符流输入流
 *      OutputStreamWriter(OutStream, StringCode): 将字符输出流转换为字节输出流
 *
 *  （文件->）字节输入流 --(解码)--> 字符输入流  ---> 对文件进行操作（字符形式） ---> 字符输出流 --(编码)--> 字节输出流（->文件）
 *      编码： 字节、字节数组 ---> 字符串，字符、字符数组
 *      解码： 字符串，字符、字符数组 ---> 字节、字节数组
 *
 *  字符集：
 *      ASCII：美国标准信息交换码
 *      ISO8859-1：拉丁码表，欧洲码表
 *      GB2312: 中文编码，最多用两个字节表示所有编码
 *      GBK: 中文编码升级版，融合了更多中文符号，最多用两个字节，兼容ASCII使用字节首位判断是一个字节的字符（首位为0），还是两个字节的中文（首位为1）
 *      Unicode: 国际标准码，融合了目前人类 使用的所有字符，为每一个字符分配唯一的字符码，所有文字都用两个字节表示
 *      UTF-8: 可变字节编码，可用1-4个字节来表示字符，根据使用字节不同，字节首位表示使用字节数（0一个，110一个，1110三个，11110四个）
 *
 */
public class ConvertStreamTest {

    /**
     * 使用转换流将文件lisao.txt文件，在控制台输出，转换成gbk编码形式lisao_gbk.txt
     *
     */
    @Test
    public void test(){
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            //1.创建对应流对象
            //创建对应解码的输入流的转换流
            inputStreamReader = new InputStreamReader(
                    new FileInputStream("src/com/atxiao2/_05_io_stream/_02_io_test/_04_convert_stream_test/files/lisao.txt"),"UTf-8");
            //创建对应编码的输出流的转换流
            outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream("src/com/atxiao2/_05_io_stream/_02_io_test/_04_convert_stream_test/files/lisao_gbk.txt"), "GBK");
            //2.调用对应方法实现需求
            char[] cbuf = new char[20];
            int len;
            while((len = inputStreamReader.read(cbuf)) != -1){
                String s = new String(cbuf, 0, len);
                System.out.print(s);
                outputStreamWriter.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
