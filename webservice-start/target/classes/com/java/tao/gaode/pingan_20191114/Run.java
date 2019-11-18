package com.java.tao.gaode.pingan_20191114;

import java.math.BigDecimal;

public class Run {

    public static void main(String[] args) {
        BigDecimal r1 = MistServiceCall.m_303("22.488841,113.925108");
        BigDecimal r2 = MistServiceCall.m_101("22.538133,114.055547");
        System.out.println("********** r1 : "+r1);
        System.out.println("********** r2 : "+r2);
    }

}
