package com.koumanwei.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2017-05-26 上午11:15
 *
 * @author koumanwei
 * @version 1.0
 */
public class TransServer {
    public static void main(String[] args) throws IOException {
        // 转换服务端
        // 1、ServerSocket服务
        // 2、获取Socket对象
        // 3、源：socket读取客户端发过来需要转换的数据
        // 4、目的：显示在控制台上
        // 5、将数据转成大写发给客户端

        ServerSocket ss = new ServerSocket(10000);
        Socket s = ss.accept();
        // 获取ip
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "....连接了");
        BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // 获取输出流
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String line;
        while ((line = brIn.readLine()) != null) {
            System.out.println(line);
            out.println(line.toUpperCase());
        }
        s.close();
        ss.close();
    }
}
