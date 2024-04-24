package com.cjh.leetcode;

import java.util.*;

public class LC380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
//        randomizedSet.insert(0);
//        randomizedSet.insert(1);
//        randomizedSet.remove(0);
//        randomizedSet.insert(2);
//        randomizedSet.remove(1);
        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(0);
        randomizedSet.insert(0);
    }


    /**
     * 这题如果需要O(1)，list需要用下标去做删除，并且将最后一位的数值替换到index位置处，并且跟新下标映射
     */
    static class RandomizedSet {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (m.containsKey(val)) return false;
            list.add(val);
            m.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!m.containsKey(val)) return false;
            int index = m.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            m.put(list.get(index), index);
            list.remove(list.size() - 1);
            m.remove(val);
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
