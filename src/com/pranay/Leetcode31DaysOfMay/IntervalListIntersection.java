package com.pranay.Leetcode31DaysOfMay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
//        Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        int[][] ans = intervalIntersection(A, B);
        for (int[] arr: ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);

            if (low <= hi)
                res.add(new int[]{low, hi});

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
