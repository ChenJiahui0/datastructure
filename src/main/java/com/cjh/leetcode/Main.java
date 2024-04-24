package com.cjh.leetcode;

import static java.lang.Math.exp;

public class Main {
    public static void main(String[] args) {
        double v = 1 - exp(-5 / 60.0 / 5);
        System.out.println(v);
    }
}
