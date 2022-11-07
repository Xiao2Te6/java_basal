package com.atxiao2._05_io_stream._01_file_test._01_test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author : XiaoEr
 * @date : 2022/9/5
 *
 * File类的使用：java.io.File
 *      File类的一个对象代表一个文件或者文件目录（文件夹）
 *      File类中只涉及到文件或文件目录的创建、删除、重命名等方法，并不涉及到写入或读取文件的内容的操作，如果需要读写文件需要使用IO流来完成
 *          后续File对象会作为参数传递到流的构造器中，指明读取或写入的”目标“
 */
public class FileTest {

    /**
     * File的实例化
     *      1. File(String pathname)
     *      2. File(String parentPath, String childPath)
     *      3. File(File file, String childPath)将file对象当成父路径在该路径下创建文件或文件夹对象
     *
     *   相对路径：某个文件夹为起点（相较于某个路径下）
     *   绝对路径：从根目录为起点
     */
    @Test
    public void test01(){
        //构造器1：File(pathName)
        File file01 = new File("com/atxiao2/_05_io_stream/_01_file_test/_01_test/hello.txt");//路径相对与当前module
        System.out.println("file01 = " + file01);
        File file02 = new File("E:\\Java\\my_all _project\\java_basal\\day08-javaplus\\src\\com\\atxiao2\\_05_io_stream\\_01_file_test\\_01_test");
        System.out.println("file02 = " + file02);

        //构造器2：File(parentPath, childPath)
        File file03 = new File("E:\\Java\\my_all _project\\java_basal\\day08-javaplus\\src\\com\\atxiao2\\_05_io_stream\\_01_file_test\\_01_test", "javaSenior");
        System.out.println("file03 = " + file03);

        //构造器3： File(file, child)
        File file04 = new File(file03, "hello.txt");
        System.out.println("file04 = " + file04);
    }

    /**
     * File常用方法一
     *  File类的获取功能
     *      getAbsolutePath（）：获取绝对路径
     *      getPath(): 获取路径
     *      getName(): 获取名称
     *      getParent(): 获取上层目录路径（父路径）若无返回null
     *
     *      //适用于文件
     *      length(): 获取文件长度（文件内容对应字节数），不能获取目录长度
     *      lastModified(): 最后一次修改时间（时间戳）
     *
     *      //适用于文件目录
     *      list(): 获取目录下所有文件或文件目录名称的Sting类型数组
     *      listFiles(): 获取目录下所有文件或目录名称的File类型数组
     */
    @Test
    public void test02(){
        //相对路径file(相对于当前module)
        File file01 = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/hello.txt");
        System.out.println(file01.getAbsolutePath());
        System.out.println(file01.getPath());
        System.out.println(file01.getName());
        System.out.println(file01.getParent());
        System.out.println(file01.length());
        System.out.println(file01.lastModified());
        System.out.println("----------------------");
        //绝对路径file
        File file02 = new File("E:\\Java\\my_all _project\\java_basal\\day08-javaplus\\src\\com\\atxiao2\\_05_io_stream\\_01_file_test\\_01_test\\hello.txt");
        System.out.println(file02.getAbsolutePath());
        System.out.println(file02.getPath());
        System.out.println(file02.getName());
        System.out.println(file02.getParent());
        System.out.println(file02.length());
        System.out.println(file02.lastModified());

        File file = new File("src/com/atxiao2");
        String[] list = file.list();//文件得存在否则报错
        for (String s : list) {
            System.out.println("s = " + s);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println("f = " + f);
        }
    }

    /**
     * File常用方法二
     *  File类的重命名方法
     *  renameTo(File dest): 把文件重命名为指定文件路径
     *          (两个file对象父路径不一样 -> 剪切+改名，两个file对象的父路径 -> 重命名)
     *      file1.renameTo(file2)
     */
    @Test
    public void test03(){
        File file1 = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/hello.txt");
        File file2 = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/filetest/hello.txt");
        //要想结果为true file1得存在，file2得不存在
        System.out.println(file1.renameTo(file2));

    }

    /**
     * File常用方法三
     *   File类的判断方法
     *      isDirectory(): 判断file对象是否为一个目录
     *      isFile(): 判断file对象是否是一个文件
     *      exists(): 判断file对象对应文件或目录是否存在
     *      canRead(): 判断文件是否可读
     *      canWrite(): 判断文件时是否可写
     *      isHidden(): 判断文件是否隐藏
     */
    @Test
    public void test04(){
        File file = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/hello.txt");
        // file = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/rename_test");
        System.out.println(file.isDirectory());//false
        System.out.println(file.isFile()); //true
        System.out.println(file.exists()); //true
        System.out.println(file.canRead()); //true
        System.out.println(file.canWrite()); //true
        System.out.println(file.isHidden()); //false

    }

    /**
     * File常用方法四
     *  File类的创建功能
     *      createNewFile(): 创建file对象对应文件，若文件存在就不创建返回false
     *      mkdir(): 创建file对象对应目录，若目录存在则不创建返回false
     *      mkdirs():  创建file对象对应的目录，若上层目录不存在则一并创建
     *
     *  File类的删除功能
     *      delete(): 删除一个文件或文件夹
     *      Java中的删除不走回收站，要删除一个文件目录，该目录下不能有文件或文件目录
     */
    @Test
    public void test05() throws IOException {
        File file = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/filetest/hello.txt");
        File file2 = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/filetest/hello");
        File file3 = new File("src/com/atxiao2/_05_io_stream/_01_file_test/_01_test/filetest/hello/world");
        System.out.println(file.createNewFile());
        System.out.println(file2.mkdir());
        System.out.println(file3.mkdirs());
    }



}
