package com.cjh.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int tmp = a[i];
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }
}
