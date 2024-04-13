package com.cjh.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        // 建大根堆
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, a.length, i);
        }
        // 每次将最大元素和最后一个数交换，然后扫描长度减一，这样我们就把最大值放到数组末尾了
        // 继续找 n-1的最大值，然后放到倒数第二个位置，这样我们就能得到倒数第二大的数，依次重复，就会得到一个正排序的数组
        for (int i = a.length - 1; i >= 0; i--) {
            int swap = a[i];
            a[i] = a[0];
            a[0] = swap;
            heapify(a, i, 0);
        }
    }

    public static void heapify(int[] a, int length, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < length && a[largest] < a[l]) largest = l;
        if (r < length && a[largest] < a[r]) largest = r;
        if (largest != i) {
            int swap = a[largest];
            a[largest] = a[i];
            a[i] = swap;
            heapify(a, length, largest);
        }
    }
}
