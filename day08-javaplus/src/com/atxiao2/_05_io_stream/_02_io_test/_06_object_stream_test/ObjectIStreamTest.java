package com.atxiao2._05_io_stream._02_io_test._06_object_stream_test;

import org.junit.Test;

import java.io.*;

/**
 * @author : XiaoEr
 * @date : 2022/10/4
 *
 * IO流之对象流
 *
 *      ObjectInputStream   readObject()
 *      ObjectOutputStream  writeObject()
 *   用于储存和读取 基本数据类型 或 对象 的处理流，可以把Java中的对象写入到数据源中，也能把对象从数据源中还原。
 *
 *   序列化：将内存中的Java对象转换成二进制流，从而允许把这种二进制流持久的保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点
 *   反序列化：程序将序列化的二进制流还原为原来的java对象
 *
 *   自定义序列化对象
 *      自定义对象的类需要实现接口:Serializable
 *      当前类需要提供一个全局常量：serialVersionUID (用来标示被序列化的对象属于这个类，防止对象序列化后类被修改反序列化找不到对应类报错，常量值随便但得有)
 *      当前类中所有的属性必须是可序列化的（默认情况下基本数据类型是可序列化的）
 *
 *   ObjectInputStream 和 ObjectOutputStream不能序列化static和 transient（瞬态 修饰属性不可被序列化）修饰的属性
 */
public class ObjectIStreamTest {

    /**
     * 将String对象写入obj.txt文件中，再读取出来
     * 将自定义对象Person 写入文件再读取
     *
     * 写入
     */
    @Test
    public void test01(){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/com/atxiao2/_05_io_stream/_02_io_test/_06_object_stream_test/files/obj.txt"));

            objectOutputStream.writeObject( "abc");
            objectOutputStream.flush();// 刷新

            objectOutputStream.writeObject(new Person("国辉",18,new Account(11.1)));
            objectOutputStream.flush();// 刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 读取
     */
    @Test
    public void test02(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src/com/atxiao2/_05_io_stream/_02_io_test/_06_object_stream_test/files/obj.txt"));

            String str =  (String)objectInputStream.readObject();
            Person person = (Person)objectInputStream.readObject();
            System.out.println(str);
            System.out.println("person = " + person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
