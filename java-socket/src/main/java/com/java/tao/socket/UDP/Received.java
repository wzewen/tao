package com.java.tao.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Received {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(1234);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);
        byte[] data = packet.getData();
        String str = new String(data, 0, packet.getLength());
        System.out.println(str);
        socket.close();
    }
}
