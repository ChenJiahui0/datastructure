package com.cjh.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5,100};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        List<List<Integer>> tmpList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            tmpList.add(new ArrayList<>());
        }
        int exp = 1;
        while(max>=exp){
            for (int i : arr) {
                tmpList.get((i / exp) % 10).add(i);
            }
            int index = 0;
            for (List<Integer> integers : tmpList) {
                for (Integer integer : integers) {
                    arr[index++] = integer;
                }
                integers.clear();
            }
            exp *= 10;
        }
    }
}
