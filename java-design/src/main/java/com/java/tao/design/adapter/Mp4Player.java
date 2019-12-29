package com.java.tao.design.adapter;

public class Mp4Player implements AdvanceMediaPlayer {
    public void playVlc(String fileName) {
        // todo nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
