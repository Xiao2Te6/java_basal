package com.atxiao2._06_winsock._01_socket_test;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author : XiaoEr
 * @date : 2022/10/6
 *
 * URL编程：
 *     URL：统一资源定位符
 *      http://www.xiaoer.asia/usr/themes/Akina/images/headerbg.jpg
 *      协议名     域名    （端口号）      资源地址     （参数列表）
 * URL类：
 *      构造器：URL(String url)
 *      常用方法：
 *
 */
public class URLTest {
    @Test
    public void test(){
        try {
            URL url = new URL("http://www.xiaoer.asia/usr/themes/Akina/images/headerbg.jpg");

            //获取协议名
            System.out.println(url.getProtocol());
            //获取主机名
            System.out.println(url.getHost());
            //获取端口号
            System.out.println(url.getPort());
            //获取资源地址
            System.out.println(url.getPath());
            //获取文件
            System.out.println(url.getFile());
            //获取该url的查询名（参数列表）
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //URL编程演示
    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.创建URl对象
            URL url = new URL("http://www.xiaoer.asia/usr/themes/Akina/images/headerbg.jpg");
            //2.获取服务器连接对象
            urlConnection = (HttpURLConnection) url.openConnection();
            //3.连接
            urlConnection.connect();
            //4.获取下载流
            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream(new File("src/com/atxiao2/_06_winsock/_01_socket_test/files/xiaoerBG.jpg"));
            //5.使用下载流读入程序，并使用流保存
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1){
                fileOutputStream.write(buff,0,len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            urlConnection.disconnect();
        }

    }
}
