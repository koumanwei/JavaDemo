package com.koumanwei.network.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 2017-05-25 下午4:49
 *
 * @author koumanwei
 * @version 1.0
 */
public class Receive implements Runnable {
    public Receive(DatagramSocket ds) {
        this.ds = ds;
    }

    private DatagramSocket ds;

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + ":" + port + ":" + str);
                if ("over".equals(str)) {
                    System.out.println(ip + "退出聊天室");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
