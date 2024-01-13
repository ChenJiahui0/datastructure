package com.cjh.ds.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        heapsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapsort(int[] a) {
        for (int i = a.length/2; i >= 0; i--) {
            heapify(a, a.length, i);
        }
        for (int i = a.length-1; i >= 0; i--) {
            int swap = a[i];
            a[i] = a[0];
            a[0] = swap;
            heapify(a, i, 0);
        }
    }
    public static void heapify(int[] a, int n, int i){
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l<n && a[largest]< a[l]) largest = l;
        if (r<n && a[largest]< a[r]) largest = r;
        if (largest!=i){
            int swap = a[largest];
            a[largest] = a[i];
            a[i] = swap;
            heapify(a, n, largest);
        }
    }
}
