package com.cjh.ds.heap;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        for (int i = a.length / 2; i >= 0; i--) {
            heapify2(a, i);
        }
        System.out.println(Arrays.toString(a));
    }

    public static void heapify(int[] array, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < array.length && array[largest] < array[l]) largest = l;
        if (r < array.length && array[largest] < array[r]) largest = r;
        if (largest != i) {
            int swap = array[largest];
            array[largest] = array[i];
            array[i] = swap;
            heapify(array, largest);
        }
    }

    public static void heapify2(int[] array, int i) {
        while (true) {
            int largest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < array.length && array[largest] < array[l]) largest = l;
            if (r < array.length && array[largest] < array[r]) largest = r;
            if (largest == i) {
                break;
            }
            int swap = array[largest];
            array[largest] = array[i];
            array[i] = swap;
            i = largest;
        }
    }
}
