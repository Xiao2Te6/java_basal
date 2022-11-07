package com.atxiao2._06_winsock._01_socket_test;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : XiaoEr
 * @date : 2022/10/5
 *
 * 网络编程
 *      直接或间接的适用网络协议与其他计算机实现数据交换，进行通讯
 *          通过IP地址定位网络上的主机，端口定位特定的应用（进程）
 *          再通过网络通信协议进行可靠高效的数据传输
 *  IP和端口号：
 *    InetAddress: java中用InetAddress表示IP地址（例如File表示文件）
 *      实例化方式：getByName(String host)：返回指定IP对应的对象，传入对象可以时IP也可以是域名
 *                getLocalhost()： 返回本地回路地址对应的对象
 *      常用方法：getHostName():  返回调用对象对应的域名
 *              getHostAddress(): 返回调用对象对应的IP地址
 *    端口号（规定使用16的整数 0~6553）和IP地址组合得出一个网络套接字：Socket
 *
 *  网络和通信协议
 *
 *
 */
public class SocketTest {

    @Test
    public void test(){
        try {
            InetAddress xiaoerBlog = InetAddress.getByName("www.xiaoer.asia");
            System.out.println("xiaoerBlog = " + xiaoerBlog);
            InetAddress localHost01 = InetAddress.getByName("127.0.0.1");
            System.out.println("localHost01 = " + localHost01);
            InetAddress localHost02 = InetAddress.getLocalHost();
            System.out.println("localHost02 = " + localHost02);
            System.out.println(xiaoerBlog.getHostAddress());
            System.out.println(xiaoerBlog.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
