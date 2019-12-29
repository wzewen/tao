package com.java.tao.design.adapter;

public class VlcPlayer implements AdvanceMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    public void playMp4(String fileName) {
        // todo nothing
    }
}
