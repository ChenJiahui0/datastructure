package com.cjh.sort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int n = a.length;
        // 获取桶的上下界
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        // 桶数设置为5
        List<Integer>[] bucket = new List[5];
        int interval = ((max - min + 1) / 5) + 1;
        for (int i = 0; i < 5; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int i : a) {
            bucket[(i - min) / (interval)].add(i);
        }
        // 对每个桶单独排序
        for (int i = 0; i < 5; i++) {
            Collections.sort(bucket[i]);
        }
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            while (bucket[j].isEmpty()) {
                j++;
            }
            a[i] = bucket[j].remove(0);
        }
    }
}
