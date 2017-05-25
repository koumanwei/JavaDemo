package com.koumanwei.network;

import java.io.IOException;
import java.net.*;

/**
 * 2017-05-25 下午3:21
 *
 * @author koumanwei
 * @version 1.0
 */
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动");
        // 创建UDP传输的发送端
        // 思路：
        // 1、建立UDP的socket服务
        // 2、将要发送的数据封装到数据包中
        // 3、通过UDP的socket服务将数据包发送出去
        // 4、关闭socket服务

        // 如果没有明确端口号，那么会默认分配一个端口号
        DatagramSocket ds = new DatagramSocket();

        String str = "UDP传输演示";
        byte[] buf = str.getBytes();
        // 封装要发送的数据
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.169"), 8989);
        // 发送
        ds.send(dp);
        ds.close();
    }
}
