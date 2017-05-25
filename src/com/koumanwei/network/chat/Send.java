package com.koumanwei.network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 2017-05-25 下午4:49
 *
 * @author koumanwei
 * @version 1.0
 */
public class Send implements Runnable {
    public Send(DatagramSocket ds) {
        this.ds = ds;
    }

    private DatagramSocket ds;

    @Override
    public void run() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = bf.readLine()) != null) {
                if ("exit".equals(line)) {
                    break;
                }
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.169"), 7788);
                ds.send(dp);
            }
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}