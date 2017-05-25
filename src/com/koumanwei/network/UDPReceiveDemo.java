package com.koumanwei.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 2017-05-25 下午3:30
 *
 * @author koumanwei
 * @version 1.0
 */
public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动");
        // 建立UDP接收端的思路：
        // 1、建立UDP socket服务，因为是接收数据，必须明确端口号
        // 2、创建数据包，用于存储接收到的数据，方便数据包对象的方法解析这些数据
        // 3、使用socket服务的receive方法接收数据存储到数据包中
        // 4、通过数据包中的方法解析数据包中的数据
        // 5、关闭资源


        DatagramSocket ds = new DatagramSocket(8989);
        byte[] buf = new byte[1024];
        // 创建数据包
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        // 使用接收方法将数据存储到数据包中
        ds.receive(dp);
        // 通过数据包对象的方法，解析其中的数据，比如：地址，端口，数据内容等
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(ip + ":" + port + ":" + s);
    }
}
