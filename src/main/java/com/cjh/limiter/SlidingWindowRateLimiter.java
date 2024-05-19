package com.cjh.limiter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowRateLimiter {
    private final int maxRequest;
    private final long windowSizeInMilliseconds;
    private final Map<Long, AtomicInteger> requests = new LinkedHashMap<>();

    public SlidingWindowRateLimiter(int maxRequest, long windowSizeInMilliseconds) {
        this.maxRequest = maxRequest;
        this.windowSizeInMilliseconds = windowSizeInMilliseconds;
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        // 清理过期的请求记录
        while (!requests.isEmpty() && currentTime - requests.keySet().iterator().next() > windowSizeInMilliseconds) {
            requests.remove(requests.keySet().iterator().next());
        }

        // 检查当前窗口是否已达到最大请求数
        if (requests.values().stream().mapToInt(AtomicInteger::get).sum() < maxRequest) {
            requests.computeIfAbsent(currentTime, k -> new AtomicInteger()).incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(3, 1000); // 允许每秒最多3个请求

        for (int i = 0; i < 6; i++) {
            Thread.sleep(200); // 模拟请求间隔
            if (rateLimiter.allowRequest()) {
                System.out.println("请求通过，时间戳：" + System.currentTimeMillis());
            } else {
                System.out.println("请求被限流，时间戳：" + System.currentTimeMillis());
            }
        }
    }
}