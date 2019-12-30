package com.java.tao.design.observer;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {
        System.out.println( "Octal String: " + Integer.toBinaryString( subject.getState() ) );
    }
}
