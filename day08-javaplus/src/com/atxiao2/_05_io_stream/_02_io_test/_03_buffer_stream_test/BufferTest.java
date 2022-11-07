package com.atxiao2._05_io_stream._02_io_test._03_buffer_stream_test;

import org.junit.Test;

import java.io.*;

/**
 * @author : XiaoEr
 * @date : 2022/9/30
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
 *  处理流之缓冲流
 *      BufferedInputStream 字节输入缓冲流
 *      BufferedOutputStream 字节输出缓冲流
 *      BufferedReader 字符输入缓冲流 readLine(): 读出一行并返回
 *      BufferedWriter 字符输入缓冲流 flush(): 将缓冲区中的数据输出（刷新出新的缓冲区）
 *  缓冲流作用：提高流的输入输出速率（原理：缓冲流内部体提供了一个缓冲区默认大小为8192）
 */
public class BufferTest {

    /**
     * 使用字节缓冲流实现图片视频等文件复制
     */
    @Test
    public void copyByBufferStream(){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.创建需要的流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("src/com/atxiao2/_05_io_stream/_02_io_test/_03_buffer_stream_test/files/n1.jpg")));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("src/com/atxiao2/_05_io_stream/_02_io_test/_03_buffer_stream_test/files/n2.jpg")));
            //2.复制细节 (使用数组)
            byte[] buffer = new byte[10];
            int len;
            while((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.释放资源,当外层处理流关闭时内层的流会自动关闭
            try {
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用字符流实现文本类型文件复制
     */
    @Test
    public void copyByBufferReaderAndWriter(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //1.创建对以后给对应流对象
            bufferedReader = new BufferedReader(new FileReader(new File("src/com/atxiao2/_05_io_stream/_02_io_test/_03_buffer_stream_test/files/hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("src/com/atxiao2/_05_io_stream/_02_io_test/_03_buffer_stream_test/files/lisao.txt")));
            //2.实现复制操作,使用字符串
            String data;
            while ((data = bufferedReader.readLine()) != null){
                bufferedWriter.write(data + "\n");
                // bufferedWriter.newLine(); //新写入一晃
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.释放资源
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
