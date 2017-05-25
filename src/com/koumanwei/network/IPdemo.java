package com.koumanwei.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 2017-05-25 下午2:07
 *
 * @author koumanwei
 * @version 1.0
 */
public class IPdemo {
    public static void main(String[] args) {
        try {
            // 获取本地主机的ip地址对象
            InetAddress ip = InetAddress.getLocalHost();
            // 192.168.169
            System.out.println(ip.getHostAddress());
            // KMW.local
            System.out.println(ip.getHostName());

            // 获取其他主机的ip地址对象
            InetAddress ip1 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip1.getHostAddress());
            InetAddress ip2 = InetAddress.getByName("www.google.com");
            System.out.println(ip2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
