package com.cjh.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            boolean isOrdered = true;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    isOrdered = false;
                }
            }
            if (isOrdered){
                break;
            }
        }
    }
}
