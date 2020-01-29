package com.java.tao.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "hello upd!";
        int len = str.length();
        DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, len, InetAddress.getByName("127.0.0.1"), 1234);
        socket.send(packet);
        socket.close();
    }

}
