package com.cjh.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @RepeatedTest(100)
    void sort() {
        Random random = new Random();
        int[] randomArray = new int[random.nextInt(1,100)];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100) + 1; // 生成1到100之间的随机数
        }
        int[] copyArray = Arrays.copyOf(randomArray,randomArray.length);
        Arrays.sort(randomArray);
        MergeSort.sort(copyArray,0,copyArray.length-1);
        assertArrayEquals(randomArray, copyArray);
    }
}