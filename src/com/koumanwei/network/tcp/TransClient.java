package com.koumanwei.network.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 2017-05-26 上午11:15
 *
 * @author koumanwei
 * @version 1.0
 */
public class TransClient {
    public static void main(String[] args) throws IOException {
        // 思路：
        // 客户端
        // 1、需要现有socket端点
        // 2、客户端的数据源：键盘
        // 3、客户端的目的：socket
        // 4、接收服务端的数据，源：socket
        // 5、将数据显示出来，目的：控制台
        // 6、在这些流中操作的数据都是文本数据

        // 转换客户端
        // 1、创建socket客户端对象
        // 2、获取键盘录入
        // 3、将录入的数据发送费socket输入流

        Socket socket = new Socket("192.168.1.169", 10000);
        // 获取键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // socket输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // socket输入流，读取服务端返回的数据
        BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            out.println(line);
            // 读取服务器发回的一行大写数据
            String upperStr = brIn.readLine();
            System.out.println(upperStr);
        }
        socket.close();
    }
}
