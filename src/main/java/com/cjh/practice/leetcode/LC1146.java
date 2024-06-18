package com.cjh.practice.leetcode;

import java.util.*;

public class LC1146 {
    public static void main(String[] args) {
        String[] op = new String[]{"SnapshotArray", "snap", "snap", "set", "snap", "get", "set", "get", "snap", "get"};
        int[][] a = {{1}, {}, {}, {0, 4}, {}, {0, 1}, {0, 12}, {0, 1}, {}, {0, 3}};
        SnapshotArray snapshotArray = new SnapshotArray(a[0][0]);
        for (int i = 1; i < op.length; i++) {
            if(op[i].equals("snap")){
                snapshotArray.snap();
            }else if (op[i].equals("set")){
                snapshotArray.set(a[i][0],a[i][1]);
            }else if(op[i].equals("get")){
                System.out.println(snapshotArray.get(a[i][0], a[i][1]));
            }
        }
    }

    static class SnapshotArray {
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,List<Integer>> index2Snapshot = new HashMap<>();
        int snapShot = 0;
        public SnapshotArray(int length) {

        }

        public void set(int index, int val) {
            map.put(snapShot+" "+index,val);
            var list = index2Snapshot.computeIfAbsent(index,a->new ArrayList<>());
            if(list.isEmpty()||list.get(list.size()-1)!=snapShot){
                list.add(snapShot);
            }
        }

        public int snap() {
            snapShot++;
            return snapShot-1;
        }

        public int get(int index, int snap_id) {
            var list = index2Snapshot.get(index);
            if(list==null)
                return 0;
            int left = 0, right = list.size();
            while(left<=right){
                int mid = (left+right)/2;
                if(list.get(mid)<snap_id){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            if (snap_id<list.get(left)) return 0;
            return map.getOrDefault(list.get(left)+" "+index,0);
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

}
