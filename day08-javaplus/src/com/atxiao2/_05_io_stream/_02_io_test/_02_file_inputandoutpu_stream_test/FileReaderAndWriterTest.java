package com.atxiao2._05_io_stream._02_io_test._02_file_inputandoutpu_stream_test;

import org.junit.Test;

import java.io.*;

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
 *     抽象基类	InputStream	        OutputStream	        Reader	            Writer
 *     文件节点流	FileInputStream	    FileOutputStream	    FileReader	        FileWriter
 *     缓冲流	BufferedInputStream	BufferedOutputStream	BufferedReader	    BufferedWriter
 *     转换流			                                    InputStreamReader	OutputStreamWriter
 *
 *  FileInputStream & FileOutStream 字节流对非字符形式文件进行处理
 */
public class FileReaderAndWriterTest {

    /**
     * FileInputStream
     *      read(byte[] byteBuffer)：将字符读入后写入数组中，并返回写入数组中的字符个数，读入到数组对应长度停止或读入到末尾返会回-1
     *          当循环读入的时候，每次会使用同一个数组，会将上次写入的数据覆盖
     */
    @Test
    public void fileInputStreamTest(){
        FileInputStream fileInputStream = null;
        try {
            //1.File类实例化
            File file = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_02_file_inputandoutpu_stream_test/files/hello.txt");
            //2.FileReader实例化
            fileInputStream = new FileInputStream(file);
            //3.读取文件中的数据
            byte[] byteBuffer = new byte[5];
            int count;
            while((count = fileInputStream.read(byteBuffer)) != -1){
                //中文占3个字符在字符串拼接时被两个数组将字符分割的地方就会乱码
                System.out.print(new String(byteBuffer,0,count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将图片使用字节流输入，然后再输出（复制图片，再改名）
     */
    @Test
    public void fileInputOutputStreamTeat(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.创建File对象指明操作文件
            File srcFile = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_02_file_inputandoutpu_stream_test/files/n1.jpg");
            File destFile = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_02_file_inputandoutpu_stream_test/files/n2.jpg");
            //2.创建流对象
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile, true);
            //3.使用read（）和write（）对文件进行操作
            int count;
            byte[] byteBuffer = new byte[5];
            while ((count = fileInputStream.read(byteBuffer)) != -1){
                fileOutputStream.write(byteBuffer,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
