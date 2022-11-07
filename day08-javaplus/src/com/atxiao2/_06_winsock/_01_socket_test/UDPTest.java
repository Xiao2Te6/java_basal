package com.atxiao2._06_winsock._01_socket_test;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author : XiaoEr
 * @date : 2022/10/6
 *
 * UDP网络编程演示
 */
public class UDPTest {

    /**
     * 发送端
     */
    @Test
    public void sender(){
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            byte[] bytes = "发送端：你好".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0, bytes.length, InetAddress.getLocalHost(), 8888);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }

    }

    /**
     * 接受端
     */
    @Test
    public void receiver(){
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8888);
            byte[] bytes = new byte[100];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0, bytes.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(),0, datagramPacket.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
