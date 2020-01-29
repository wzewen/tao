package com.java.tao.socket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Send {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 2345);
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("hello tcp!".getBytes());
        s.close();


    }
}
