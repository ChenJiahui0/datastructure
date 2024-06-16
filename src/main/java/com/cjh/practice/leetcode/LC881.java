package com.cjh.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC881 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int l = 0, r = people.length - 1;
            int res = 0;
            while (l <= r) {
                if (people[l] + people[r] <= limit) {
                    l++;
                }
                res++;
                r--;
            }
            return res;
        }
    }
}
