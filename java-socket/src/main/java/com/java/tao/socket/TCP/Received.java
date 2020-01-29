package com.java.tao.socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Received {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(2345);
        Socket s = socket.accept();
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String server = new String(bys, 0, len);
        System.out.println("server:" + server);
        s.close();
    }
}
