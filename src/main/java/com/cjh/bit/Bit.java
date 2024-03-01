package com.cjh.bit;

public class Bit {
    int[] parent;

    public Bit(int[] num) {
        parent = new int[num.length + 1];
        for (int i = 0; i < num.length; i++) {
            parent[i+1] = num[1];
        }
        for(int i=1;i<num.length+1;i++){
            int j = i + i & (-i);
            if(j<num.length+1) parent[j] += parent[i];
        }
    }

    public int sum(int x) {
        int sum = 0;
        for (x++; x > 0; x -= x & (-x)) {
            sum += parent[x];
        }
        return sum;
    }

    public void update(int x, int val) {
        for (x++; x < parent.length; x += x & (-x)) {
            parent[x] += val;
        }
    }
}
