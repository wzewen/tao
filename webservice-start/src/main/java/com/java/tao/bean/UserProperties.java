package com.java.tao.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * UserProperties
 *
 * @author zewen.wang
 * @date 2020/4/16
 */
@Component
@ConfigurationProperties(prefix = "run")
public class UserProperties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
