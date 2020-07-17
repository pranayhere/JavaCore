package com.pranay.interview.design;

import java.util.Arrays;
import java.util.TreeMap;

public class SnapshotArrSpaceOptimized {
    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;

    public SnapshotArrSpaceOptimized(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < A.length; i++) {
            A[i] = new TreeMap<Integer, Integer>();
            A[i].put(0, 0);
        }
    }

    public static void main(String[] args) {
        SnapshotArrSpaceOptimized snapshotArr = new SnapshotArrSpaceOptimized(3); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        System.out.println(snapshotArr.get(0,0));  // Get the value of array[0] with snap_id = 0, return 5
        System.out.println(snapshotArr.get(0,1));
    }

    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        System.out.println(Arrays.toString(A));
        return A[index].floorEntry(snap_id).getValue();
    }
}
