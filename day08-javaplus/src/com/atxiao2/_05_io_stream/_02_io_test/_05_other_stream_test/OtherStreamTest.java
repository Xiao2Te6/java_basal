package com.atxiao2._05_io_stream._02_io_test._05_other_stream_test;

import org.junit.Test;

import java.io.*;

/**
 * @author : XiaoEr
 * @date : 2022/10/2
 *
 * IO流之
 *  标准的输入输出流(节点流)
 *      System.in 标准的输入流，默认从键盘输入 (字节输入流)
 *      System.out 标准的输出流，默认输出到控制台 （字节打印输出流,默认输出到控制台）
 *    System类的setIn(InputStream in)/ setOut(OutputStream out) 方法可以重新指定输入和输出的流
 *
 *  打印流：将基本数据类型的数据格式转换为字符串输出(不止输出到控制台)（处理流）
 *      PrintStream
 *      PrintWriter
 *    打印流提供了一系列重载的print() 和 println() 方法
 *    System.out返回的就是PrintStream的实例，不会抛异常，会自动flush。
 *
 *  数据流: Java基本数据类型和String类型使用的流 （处理流）
 *    DataInputStream
 *    DataOutputStream
 *      常用方法(read/write)：readBoolean()：读入Boolean类型
 *                          readXxx(): 读入Xxx类型
 *                          readUTF(): 读入字符串
 *                          readFully(byte[]): 读入到字节数组
 *
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        new OtherStreamTest().test01();
    }
    /**
     *标准的输入输出流
     *     使用流从键盘键入字符串，整行转换成大写再输出到控制台，直到输入“e”或者“exit”时退出程序
     */
     @Test
    public void  test01(){

         BufferedReader inStream = null;
         try {
             inStream = new BufferedReader(new InputStreamReader(System.in));
             System.out.print("请输入：");
             while (true){
                 String s = inStream.readLine();
                 if("e".equalsIgnoreCase(s)  || "exit".equalsIgnoreCase(s)){
                     return;
                 }else{
                     System.out.println("你输入的是： " + s.toUpperCase());
                     System.out.print("请继续输入:");
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (inStream != null){
                 try {
                     inStream.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }

     }

    /**
     *打印流
     *  使用打印流将ASCII码对应的字符输出到文件中，每50个字符就换行
     */
    @Test
    public void  test02(){

        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/com/atxiao2/_05_io_stream/_02_io_test/_05_other_stream_test/files/ascii.txt");
            //创建写入文件的打印流，设置自动刷新模式（当遇到换行或“\n” 就会 属性输入缓冲区）
            printStream = new PrintStream(fileOutputStream,true);
            if (printStream != null){
                System.setOut(printStream);
            }
            for (int i = 0; i <= 255; i++){
                System.out.print((char)i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(printStream != null){
                printStream.close();
            }
        }
    }

    /**
     * 数据流
     *   简单演示数据流的使用(写入)
     */
    @Test
    public void  test03(){
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File("src/com/atxiao2/_05_io_stream/_02_io_test/_05_other_stream_test/files/type.txt")));
            dataOutputStream.writeUTF("hello");
            dataOutputStream.flush();
            dataOutputStream.writeInt(16);
            dataOutputStream.flush();
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {


                }
            }
        }
    }

    /**
     * 数据流
     *   简单演示数据流的使用(读取)
     */
    @Test
    public void test04(){
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(new File("src/com/atxiao2/_05_io_stream/_02_io_test/_05_other_stream_test/files/type.txt")));

            //读取要按照写入的顺序来
            String s = dataInputStream.readUTF();
            int i = dataInputStream.readInt();
            boolean b = dataInputStream.readBoolean();
            System.out.println(s + "\n" + i + "\n" + b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null){
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
