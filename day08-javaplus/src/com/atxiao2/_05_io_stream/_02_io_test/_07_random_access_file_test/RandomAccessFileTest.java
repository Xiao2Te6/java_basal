package com.atxiao2._05_io_stream._02_io_test._07_random_access_file_test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author : XiaoEr
 * @date : 2022/10/4
 *
 * RandomAccessFile: 随机（随意）存储流
 *      RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOut接口
 *      RandomAccessFile既可以作为输入流(文件不存在会报错)也可以作为一个输出流（文件不存在会自动创建），具体根据构造器中的mode参数而定
 *          RandomAccessFile（file，mode） mode："r" "w" "rw" "rwd" "rws"
 *      RandomAccessFile作为输出流如果文件存在会将文件中的内容从指针位置（默认为文件开始位置）开始一一对应覆写
 *
 *          getFilePointer()：获取指针
 *          seek(long pos):调整文件指针
 *
 *  适用环境举例：多线程断点下载
 */
public class RandomAccessFileTest {

    /**
     * 演示RandomAccessFile的使用
     *  复制问文件hello 为 hi
     */
    @Test
    public void test01(){
        RandomAccessFile randomAccessFileR = null;
        RandomAccessFile randomAccessFileRW = null;
        try {
            File file = new File("src/com/atxiao2/_05_io_stream/_02_io_test/_07_random_access_file_test/files/hello.txt");
            randomAccessFileR = new RandomAccessFile(file,"r");
            randomAccessFileRW = new RandomAccessFile("src/com/atxiao2/_05_io_stream/_02_io_test/_07_random_access_file_test/files/hi.txt","rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = randomAccessFileR.read(buffer)) != -1){
                randomAccessFileRW.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFileR != null){
                try {
                    randomAccessFileR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFileRW != null){
                try {
                    randomAccessFileRW.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 演示RandomAccessFile的内容覆写
     */
    @Test
    public void test02(){
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/com/atxiao2/_05_io_stream/_02_io_test/_07_random_access_file_test/files/hi.txt", "rw");

            randomAccessFile.write("XYZ".getBytes());

            randomAccessFile.seek(10);

            randomAccessFile.write("XYZ".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 使用已学过的方法实现RandomAccessFile插入操作
     *    在test.txt文件中abc后插入WXE
     */
    @Test
    public void test03(){
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/com/atxiao2/_05_io_stream/_02_io_test/_07_random_access_file_test/files/test.txt", "rw");
            //将指针调整到要插入位置
            randomAccessFile.seek(3);
            StringBuffer stringBuffer = new StringBuffer((int) new File("src/com/atxiao2/_05_io_stream/_02_io_test/_07_random_access_file_test/files/test.txt").length());
            byte[] buffer = new byte[1024];
            int len;
            //将插入位置后的字符读取出来封装成单个字符串存入StringBuffer中
            while ((len = randomAccessFile.read(buffer)) != -1){
                stringBuffer.append(new String(buffer, 0, len));
            }
            //再将指针调整到插入位置
            randomAccessFile.seek(3);
            //将要覆写内容写进去
            randomAccessFile.write("WXE".getBytes());
            //再将插入位置后提前保存的内容跟着覆写进去
            randomAccessFile.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
