package com.cjh.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {3, 2, 4, 5};
        quickSort(ints,0,3);
        System.out.println(Arrays.toString(ints));
    }
    public static void quickSort(int[] arr,int left,int right) {
        if (left>=right) return;
        int i = left, j = right;
        int key = arr[right];
        while(i<j){
            while(i<j && arr[i]<key) i++;
            if(i<j) arr[j] = arr[i];
            while(i<j && arr[j]>=key) j--;
            if(i<j) arr[i] = arr[j];
        }
        arr[j] = key;
        quickSort(arr,left,j-1);
        quickSort(arr,j+1,right);
    }
}
