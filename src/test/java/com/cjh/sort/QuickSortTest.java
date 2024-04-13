package com.cjh.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @RepeatedTest(100)
    void sort() {
        Random random = new Random();
        int[] randomArray = new int[random.nextInt(1,100)];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100) + 1; // 生成1到100之间的随机数
        }
        int[] copyArray = Arrays.copyOf(randomArray,randomArray.length);
        Arrays.sort(randomArray);
        QuickSort.sort(copyArray);
        assertArrayEquals(randomArray, copyArray);
    }
}