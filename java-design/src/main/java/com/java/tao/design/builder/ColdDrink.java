package com.java.tao.design.builder;

public class ColdDrink implements Item {
    public String name() {
        return null;
    }

    public Packing packing() {
        return new Bottle();
    }

    public float price() {
        return 0;
    }
}
