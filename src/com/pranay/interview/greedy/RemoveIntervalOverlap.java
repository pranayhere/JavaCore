package com.pranay.interview.greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://binarysearch.com/problems/Remove-Interval-Overlaps
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * The intervals are not necessarily sorted in any order.
 */
public class RemoveIntervalOverlap {
    public static void main(String[] args) {
        int[][] intervals = {
                {7, 9},
                {2, 4},
                {5, 8},
        };

        int count = minRemoval(intervals);
        System.out.println("Min removal is : " + count);
    }

    private static int minRemoval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        System.out.println(Arrays.deepToString(intervals));

        Stack<int[]> stk = new Stack<>();
        int count = 0;
        for (int[] interval: intervals) {
            if (!stk.isEmpty() && stk.peek()[1] > interval[0]) {
                int[] top = stk.pop();
                if (top[1] > interval[1])
                    stk.push(interval);
                else
                    stk.push(top);

                count++;
            } else {
                stk.push(interval);
            }
        }

        return count;
    }
}
