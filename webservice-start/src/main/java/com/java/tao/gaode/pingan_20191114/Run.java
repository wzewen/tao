package com.java.tao.gaode.pingan_20191114;

import java.math.BigDecimal;

public class Run {

    public static void main(String[] args) {
        int i = MistServiceCall.m_212("22.538133,114.055547");
        int j = MistServiceCall.m_212("22.540543,114.107610");
        System.out.println("************************ i : "+i);
        System.out.println("************************ j : "+j);
    }


}
