package com.atxiao2._06_winsock._01_socket_test;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : XiaoEr
 * @date : 2022/10/6
 *
 * 实现TCP的网络编程：客户端发文件ni.jpg给服务端，服务端将文件保存到本地n2.jpg,然后给予反馈给服务端,
 */
public class TCPTest02 {

    /**
     * 客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bytes = null;
        try {
            //1.创建客服端的socket对象
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            //2.客户端的输出流对象
            outputStream = socket.getOutputStream();
            //3.创建文件输入流对象
            fileInputStream = new FileInputStream(new File("src/com/atxiao2/_06_winsock/_01_socket_test/files/n1.jpg"));
            //4.使用文件输入流对象读取文件再使用客服端输出流发送
            byte[] buff = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buff)) != -1){
                outputStream.write(buff,0,len);
            }

            //5.关闭输出流进程，让服务端知晓发送完成可以进行下一步操作
            socket.shutdownOutput();

            //6.接受服务端反馈
            inputStream = socket.getInputStream();
            //ByteArrayOutputStream会将数据写入到内部的byte数组中
            bytes = new ByteArrayOutputStream();
            byte[] buff02 = new byte[1024];
            int len02;
            while ((len02 = inputStream.read(buff02)) != -1){
                bytes.write(buff02,0,len02);
            }
            System.out.println(bytes.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bytes != null){
                try {
                    bytes.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
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
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            //1.创建服务端SererSocket对象
            serverSocket = new ServerSocket(8888);
            //2.
            socket = serverSocket.accept();
            //3.
            inputStream = socket.getInputStream();
            //4.
            fileOutputStream = new FileOutputStream("src/com/atxiao2/_06_winsock/_01_socket_test/files/n2.jpg");
            //5.
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1){
                fileOutputStream.write(buff, 0, len);
            }

            //6.服务端给予反馈给客户端
            outputStream = socket.getOutputStream();
            outputStream.write("我收到图片了。".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
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
