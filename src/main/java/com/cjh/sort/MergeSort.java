package com.cjh.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5,100};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int start,int end){
        if(end == start) return;
        int mid = (start + end) / 2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        int i = start, j = mid + 1;
        while(i<=mid && j<=end){
            if(arr[i]>arr[j]){
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j++;
            }else{
                i++;
            }
        }
    }
}
