package com.java.tao.socket.base.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Sender {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 2345);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello TCP!".getBytes());
        socket.close();
    }
}
