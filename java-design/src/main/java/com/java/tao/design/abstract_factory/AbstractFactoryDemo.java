package com.java.tao.design.abstract_factory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractFactory shape = FactoryProducer.getFactory("shape");
        Shape circle = shape.getShape("circle");
        circle.draw();
        Shape square = shape.getShape("square");
        square.draw();
        Shape rectangle = shape.getShape("rectangle");
        rectangle.draw();

        AbstractFactory color = FactoryProducer.getFactory("color");
        Color red = color.getColor("red");
        red.fill();
        Color green = color.getColor("green");
        green.fill();
        Color blue = color.getColor("blue");
        blue.fill();
    }
}
