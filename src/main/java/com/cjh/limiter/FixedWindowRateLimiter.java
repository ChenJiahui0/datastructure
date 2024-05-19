package com.cjh.limiter;

import lombok.extern.java.Log;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 固定窗口限流
 */
@Log
public class FixedWindowRateLimiter {
    //时间窗口大小，单位毫秒
    long windowSize;
    //允许通过的请求数
    int maxRequestCount;
    //当前窗口通过的请求数
    AtomicInteger counter = new AtomicInteger(0);
    //窗口右边界
    long windowBorder;
    public FixedWindowRateLimiter(long windowSize, int maxRequestCount) {
        this.windowSize = windowSize;
        this.maxRequestCount = maxRequestCount;
        this.windowBorder = System.currentTimeMillis() + windowSize;
    }
    public synchronized boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        // 如果当前时间大于上一个窗口边界，那么以当前时间新开一个窗口
        if (windowBorder < currentTime) {
            log.info("window reset");
            do {
                windowBorder += windowSize;
            } while (windowBorder < currentTime);
            counter = new AtomicInteger(0);
        }

        if (counter.intValue() < maxRequestCount) {
            counter.incrementAndGet();
            log.info("tryAcquire success");
            return true;
        } else {
            log.info("tryAcquire fail");
            return false;
        }
    }
}