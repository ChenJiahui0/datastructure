package com.cjh.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int n = a.length;
        for (int step = n / 2; step >= 1; step /= 2) {
            for (int i = step; i < n; i++) {
                int j = i - step;
                int tmp = a[i];
                while (j >= 0 && a[j] > tmp) {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = tmp;
            }
        }
    }
}
