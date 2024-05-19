package com.cjh.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread {
    public static void main(String[] args) {
        int n = 0;
        Object o = new Object();
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> {
            int count = 0;
            if(n%2==1 && count<50){

                    reentrantLock.lock();
                    System.out.println("a");
                    reentrantLock.unlock();

            }

        }).start();
        new Thread(() -> {
            int count = 0;

            while (count++ < 50) {
                reentrantLock.lock();
                System.out.println("b");
                reentrantLock.unlock();
            }


        }).start();
    }
}
