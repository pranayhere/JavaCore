package com.pranay.interview.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/snapshot-array/
 *
 * Use a list of lists, adding both the element and the snap_id to each index.
 */
public class SnapshotArray {
    List<List<Integer>> snapshot = new ArrayList<>();
    Integer[] arr;

    public SnapshotArray(int length) {
        arr = new Integer[length];
        Arrays.fill(arr, 0);
    }

    public static void main(String[] args) {
//        SnapshotArray snapshotArr = new SnapshotArray(4); // set the length to be 4
//        System.out.println(snapshotArr.snap());
//        System.out.println(snapshotArr.snap());
//        System.out.println(snapshotArr.get(3,1));
//        snapshotArr.set(2, 4);
//        System.out.println(snapshotArr.snap());
//        snapshotArr.set(1, 4);

        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        System.out.println(snapshotArr.get(0,0));  // Get the value of array[0] with snap_id = 0, return 5
        System.out.println(snapshotArr.get(0,1));
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int snap() {
        List<Integer> list = Arrays.asList(arr);
        snapshot.add(new ArrayList<>(list));
        return snapshot.size() - 1;
    }

    public int get(int index, int snap_id) {
        System.out.println(snapshot);
        List<Integer> snapList = snapshot.get(snap_id);
        return snapList.get(index);
    }
}
