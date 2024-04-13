package com.cjh.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] counter = new int[max - min + 1];
        for (int i : a) {
            counter[i - min]++;
        }
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            while (counter[j] == 0) j++;
            a[i] = j + 1;
            counter[j]--;
        }
    }
}
