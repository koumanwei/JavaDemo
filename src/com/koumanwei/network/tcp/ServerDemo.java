package com.koumanwei.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2017-05-26 上午9:45
 *
 * @author koumanwei
 * @version 1.0
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 服务端接收客户端发过来的数据，并打印在控制台上

        // 建立tcp服务端的思路
        // 1、创建服务端socket服务，通过通过ServerSocket对象
        // 2、服务器必须对外提供一个端口，否则客户端无法连接
        // 3、获取连接过来的客户端对象
        // 4、通过客户端对象获取socket流读取客户端发过来的数据
        // 5、关闭资源（断开连接），关客户端，关服务端

        // 创建服务端对象
        ServerSocket ss = new ServerSocket(1122);
        // 获取连接过来的客户端对象
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        // 通过socket对象获取输入流，要读取客户端发来的数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        StringBuffer sb = new StringBuffer();
        while ((len = in.read(buf)) != -1) {
            sb.append(new String(buf, 0, len));
        }
        System.out.println(ip + sb.toString());
        s.close();
        // 服务端一般不关闭，因为要一直对外提供服务
    }
}
