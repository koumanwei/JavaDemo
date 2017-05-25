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
public class UDPReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端开始接收了");
        DatagramSocket ds = new DatagramSocket(8989);
        while (true) {
            byte[] buf = new byte[1024];
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
}
