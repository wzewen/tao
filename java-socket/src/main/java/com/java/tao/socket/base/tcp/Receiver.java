package com.java.tao.socket.base.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(2345);
        Socket accept = socket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes, 0, len));
        }
        socket.close();
    }
}
