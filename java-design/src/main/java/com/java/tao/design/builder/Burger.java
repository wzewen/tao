package com.java.tao.design.builder;

public class Burger implements Item {
    public String name() {
        return null;
    }

    public Packing packing() {
        return new Wrapper();
    }

    public float price() {
        return 0;
    }
}
