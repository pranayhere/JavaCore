package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class MinDifferenceWithMoves {
    public static void main(String[] args) {
        int[] nums = {82,81,95,75,20};
        int diff = minDifference(nums);
        System.out.println(diff);
    }

    private static int minDifference(int[] A) {
        int n = A.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }
}
