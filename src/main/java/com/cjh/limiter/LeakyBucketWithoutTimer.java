package com.cjh.limiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LeakyBucketWithoutTimer {
    private final int capacity; // 桶的容量
    private final int leakRate; // 单位时间（比如秒）内漏水的数量
    private final AtomicInteger waterLevel = new AtomicInteger(0); // 当前水位（请求计数）
    private long lastLeakTime = System.nanoTime(); // 上次漏水时间

    public LeakyBucketWithoutTimer(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    public boolean allowRequest() {
        long currentTime = System.nanoTime();
        // 计算自上次漏水以来经过的时间，以纳秒为单位
        long elapsedTime = currentTime - lastLeakTime;
        // 根据时间计算应减少的水量
        int leakedWater = (int) (elapsedTime * leakRate / TimeUnit.SECONDS.toNanos(1));
        // 确保leakedWater不会超过当前水位
        leakedWater = Math.min(waterLevel.get(), leakedWater);
        
        // 更新水位
        waterLevel.addAndGet(-leakedWater);
        if (waterLevel.get() < 0) {
            waterLevel.set(0); // 防止水位变为负数
        }
        lastLeakTime = currentTime; // 更新最后漏水时间
        
        // 检查水位是否允许新的请求
        if (waterLevel.get() < capacity) {
            waterLevel.incrementAndGet(); // 加入新的请求
            return true;
        } else {
            return false;
        }
    }
}