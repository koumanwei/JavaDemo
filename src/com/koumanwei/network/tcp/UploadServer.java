package com.koumanwei.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2017-05-31 上午10:11
 *
 * @author koumanwei
 * @version 1.0
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10009);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostName());
        // 源
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // 目的
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/koumanwei/Desktop/server.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("上传成功");
        br.close();
        s.close();
        ss.close();
    }
}
