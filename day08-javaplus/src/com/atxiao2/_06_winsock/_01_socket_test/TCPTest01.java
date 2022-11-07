package com.atxiao2._06_winsock._01_socket_test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : XiaoEr
 * @date : 2022/10/6
 *
 * TCP
 *     演示TCP协议传输方式：客户端发送内容到服务端，服务端打印内容
 */
public class TCPTest01 {

    /**
     * 客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1.创建socket指定服务端IP和端口号
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            //2.获取socket内部的流
            outputStream = socket.getOutputStream();
            //3.使用socket内部的流输出发送内容
            outputStream.write("你好服务端，来块牛排".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 服务端
     */
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        InputStreamReader reader = null;

        try {
            //1.创建服务端的ServerSocket对象
            serverSocket = new ServerSocket(8888);
            //2.使用服务端的ServerSocket对象获取客户端的socket对象
            socket = serverSocket.accept();
            //3.获取socket中的输入流
            inputStream = socket.getInputStream();
            //4.因为是传输内容是中文防止乱码转换成字符流
            reader = new InputStreamReader(inputStream);
            //5.读取内容
            char[] cbuf = new char[1024];
            int len;
            while((len = reader.read(cbuf)) != -1){
                System.out.println(new String(cbuf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if(reader != null){
                try {
                    reader.close();
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
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
