package com.pranay.interview.searching;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 436. Find Right Interval
 * https://leetcode.com/problems/find-right-interval/
 */
public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        int[] ans = findRightInterval(intervals);
        System.out.println("Ans : " + Arrays.toString(ans));
    }

    private static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++)
            starts.put(intervals[i][0], i);

        for (int i = 0; i < intervals.length; i++) {
            Integer rightStart = starts.ceilingKey(intervals[i][1]);
            res[i] = rightStart == null ? -1 : starts.get(rightStart);
        }

        return res;
    }
}
