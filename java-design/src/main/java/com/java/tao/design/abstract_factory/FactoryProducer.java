package com.java.tao.design.abstract_factory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String name){
        if(name==null){
            return null;
        }
        if(name.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if(name.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
