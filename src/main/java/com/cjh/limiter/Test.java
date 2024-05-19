package com.cjh.limiter;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(1000, 1);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            sc.next();
            System.out.println(fixedWindowRateLimiter.tryAcquire());
        }
    }
}
