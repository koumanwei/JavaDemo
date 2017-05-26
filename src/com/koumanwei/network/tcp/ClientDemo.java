package com.koumanwei.network.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 2017-05-26 上午9:43
 *
 * @author koumanwei
 * @version 1.0
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 客户端发送数据到服务端

        // tcp传输的时候客户端建立的过程
        // 1、创建tcp客户端socket服务，建议该对象一创建就明确目的地，要连接的主机
        // 2、如果连接建立成功，说明数据传输通道已经建立，通道就是网络IO流，Socket流
        // 是底层建立好的，既然是流，说明这里既有输入，又有输出；想要输入或者输出流对象，可以找Socket来获取
        // 可以通过getOutputStream和getInputStream获取
        // 3、使用输出流，将数据写出
        // 4、关闭资源

        // 创建客户端服务
        Socket socket = new Socket("192.168.1.169", 1122);
        // 获取Socket流中的输出流，这个资源可以不用关闭，因为是socket的资源关闭了socket就可以
        OutputStream os = socket.getOutputStream();
        // 使用输出流将指定的数据写出去
        os.write("TCP演示".getBytes());
        // 关闭资源
        socket.close();
    }
}
