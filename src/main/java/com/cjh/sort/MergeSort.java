package com.cjh.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {31, 232, 4, 5, 100, 32};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (end == start) return;
        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        int i = start, j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int index = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                tmp[index++] = arr[j++];
            } else {
                tmp[index++] = arr[i++];
            }
        }
        while (j <= end) {
            tmp[index++] = arr[j++];
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        System.arraycopy(tmp, 0, arr, start, tmp.length);
    }
}
