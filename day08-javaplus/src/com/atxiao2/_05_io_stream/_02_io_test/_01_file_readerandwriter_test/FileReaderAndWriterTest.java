package com.atxiao2._05_io_stream._02_io_test._01_file_readerandwriter_test;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : XiaoEr
 * @date : 2022/9/28
 *
 * IO流 分类
 *      按照数据单位分：字节流（8bit byte）、字符流(16bit char 常用来处理txt文本)
 *      按照流的流向分： 输入流（从硬盘（文件）输入到程序（内存）中） 、 输出流（从程序（内存）输出到硬盘（文件）中）
 *      按照角色分： 节点流（程序直接操作文件的流） 、 处理流（作用于流，用来操作流的流）
 *
 * IO流常用类体系
 *      分类	    字节输入流	        字节输出流	            字符输入流	        字符输出流
 *      抽象基类	InputStream	        OutputStream	        Reader  	        Writer
 *      文件流	FileInputStream	    FileOutputStream	    FileReader	        FileWriter
 *      缓冲流	BufferedInputStream	BufferedOutputStream	BufferedReader	    BufferedWriter
 *      转换流			                                    InputStreamReader	OutputStreamWriter
 *      打印流		                PrintStream		                            PrintWrite
 *      特殊流   DataInputStream	    DataOutputStream
 *      对象流	ObjectInputStream	ObjectOutputStream
 *   标准的输入输出流
 * 	        System.in  节点流、输入流、字节流
 *      	System.out  默认输出到控制台  输出流、字节流
 *      随机存储流：RandomAccessFile
 *
 *   NIO2 中的Path类：File类的升级版
 * 		 Paths类 ：封装Path获取实例和Path类操作方法的工具类
 * 		 Files类：提供了更多操作File类方法的工具类
 *
 * FileReader & FileWriter 字符流对字符形式文件进行处理
 */
public class FileReaderAndWriterTest {

    /**
     * FileReader
     *      read()：返回当前文件指针指向的字符，并将移向下一个字符，如果达到文件末尾就返回-1
     *          效率底
     */
    @Test
    public void fileReaderTest01(){
        FileReader fileReader = null;
        try {
            //1.创建File对象
            File file = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_01_file_readerandwriter_test/files/hello.txt");

            //2.创建文件输入字节流对象
            fileReader = new FileReader(file);

            //3.使用read()读出文件中的内容并打印
            int data;
            while ((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流，释放资源
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileReader
     *      read(char[] charBuffer)：将字符读入后写入数组中，并返回写入数组中的字符个数，读入到数组对应长度停止或读入到末尾返会回-1
     *          当循环读入的时候，每次会使用同一个数组，会将上次写入的数据覆盖
     */
    @Test
    public void fileReaderTest02(){
        FileReader fileReader = null;
        try {
            //1.File类实例化
            File file = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_01_file_readerandwriter_test/files/hello.txt");
            //2.FileReader实例化
            fileReader = new FileReader(file);
            //3.读取文件中的数据
            char[] charBuffer = new char[5];
            int count;
            while((count = fileReader.read(charBuffer)) != -1){
                // //方式一
                for (int i = 0; i < count; i++){ //如果不是用count就会出现 hello,world!d！会将最后一次数组没有覆盖的一并输出x
                    System.out.print(charBuffer[i]);
                }

                // //方式二 使用Sting构造器将charBuffer数组中的字符转换String 从0开始到count结束
                // System.out.print(new String(charBuffer,0,count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * FileWriter
     *      write(String)/write(char[]): 将传入的参数输出（写入）到流对应文件中
     *      在写入时允许文件不存在，如果不存在会自动创建
     *                         如果存在默认会覆盖原有文件内容；可以使用FileWriter（file，true）改为追加
     */
    @Test
    public void FileWriterTest01(){
        FileWriter fileWriter = null;
        try {
            //1.实例化File对象，指明需要操作文件
            File file = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_01_file_readerandwriter_test/files/dream.txt");
            //2.实例化FileWriter
            fileWriter = new FileWriter(file);
            //3.使用write（）进行写入
            fileWriter.write("I have a dream!\n");
            fileWriter.write("You need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 将hello.txt文件读入，然后输出为hi.txt(复制并改名)
     */
    @Test
    public void copy(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建对应文件的File对象
            File srcFile = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_01_file_readerandwriter_test/files/hello.txt");
            File destFile = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_01_file_readerandwriter_test/files/hi.txt");
            //2.创建对应流资源
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile,true);
            //3.使用read（）和write（）对文件进行操作
            char[] charBuffer = new char[5];
            int count;//每次读入到charBuffer[]中的字符个数
            while((count = fileReader.read(charBuffer)) != -1){
                fileWriter.write(charBuffer,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if(fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
