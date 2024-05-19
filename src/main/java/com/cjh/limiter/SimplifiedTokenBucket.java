package com.cjh.limiter;

import java.util.concurrent.TimeUnit;

public class SimplifiedTokenBucket {
    private final long capacity; // 桶的容量
    private final long refillRate; // 每秒填充速度（令牌数）
    private long tokens; // 当前令牌数量
    private long lastRefillTime; // 上次填充时间

    public SimplifiedTokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokensToConsume) {
        long now = System.nanoTime();
        // 根据时间差计算新增的令牌数
        long tokensToAdd = (now - lastRefillTime) * refillRate / TimeUnit.SECONDS.toNanos(1);
        // 保证令牌数量不超过桶的容量
        tokens = Math.min(tokens + tokensToAdd, capacity);
        lastRefillTime = now;

        if (tokens >= tokensToConsume) {
            tokens -= tokensToConsume;
            return true;
        }
        return false;
    }
}