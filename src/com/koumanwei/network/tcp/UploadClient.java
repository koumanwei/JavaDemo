package com.koumanwei.network.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 2017-05-31 上午9:51
 *
 * @author koumanwei
 * @version 1.0
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.1.169", 10009);
        // 源
        BufferedReader br = new BufferedReader(new FileReader("/Users/koumanwei/Desktop/client.txt"));
        PrintWriter out = new PrintWriter(s.getOutputStream());
        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
        }
        s.shutdownOutput();
        // 读取服务端返回的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String resStr = bufferedReader.readLine();
        System.out.println(resStr);
        br.close();
        s.close();
    }
}
