package com.koumanwei.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 2017-05-26 上午9:43
 *
 * @author koumanwei
 * @version 1.0
 */
public class ClientDemo2 {
    public static void main(String[] args) throws IOException {

        // 创建客户端服务
        Socket socket = new Socket("192.168.1.169", 2233);
        // 获取Socket流中的输出流，这个资源可以不用关闭，因为是socket的资源关闭了socket就可以
        OutputStream os = socket.getOutputStream();
        // 使用输出流将指定的数据写出去
        os.write("TCP演示".getBytes());
        // 读取服务端返回的数据
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf, 0, len);
        System.out.println(text);
        // 关闭资源
        socket.close();
    }
}
