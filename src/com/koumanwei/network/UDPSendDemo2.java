package com.koumanwei.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 2017-05-25 下午3:21
 *
 * @author koumanwei
 * @version 1.0
 */
public class UDPSendDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println("发送开始了");
        DatagramSocket ds = new DatagramSocket();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.169"), 8989);
            ds.send(dp);
        }
        ds.close();
    }
}
