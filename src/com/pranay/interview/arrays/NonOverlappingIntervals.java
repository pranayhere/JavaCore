package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 */

public class NonOverlappingIntervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{1,2},{1,2},{1,2}};
//        int[][] intervals = {{1,2},{2,3}};
//        int[][] intervals = {{1,1}, {2,2}};
//        int[][] intervals = {};
        int[][] intervals = {{1,5}, {2,3}, {3,4}, {4,5}};
        int count = eraseOverlapIntervals(intervals);
        System.out.println("Count : " + count);
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev = 0;
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}
