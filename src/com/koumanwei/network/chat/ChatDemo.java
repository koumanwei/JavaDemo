package com.koumanwei.network.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 2017-05-25 下午5:02
 *
 * @author koumanwei
 * @version 1.0
 */
public class ChatDemo {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send = new DatagramSocket();
        DatagramSocket receive = new DatagramSocket(7788);
        Send s = new Send(send);
        Receive r = new Receive(receive);
        new Thread(s).start();
        new Thread(r).start();
    }
}
