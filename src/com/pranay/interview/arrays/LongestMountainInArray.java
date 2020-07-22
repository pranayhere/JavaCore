package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 845. Longest Mountain in Array
 * https://leetcode.com/problems/longest-mountain-in-array
 */
public class LongestMountainInArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,3,2,1,1,2,3,4,5,6,7,7,5,4,3,2,1};
        int mountain = longestMountain(A);
        System.out.println("Longest Mountain : " + mountain);
    }

    private static int longestMountain(int[] A) {
        if (A.length < 3)
            return 0;

        int[] increasing = new int[A.length];
        int[] decreasing = new int[A.length];
        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1])
                increasing[i] = increasing[i - 1] + 1;
        }

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1])
                decreasing[i] = decreasing[i + 1] + 1;
        }

//        System.out.println(Arrays.toString(increasing));
//        System.out.println(Arrays.toString(decreasing));

        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) { // peek point
                ans = Math.max(ans, increasing[i] + decreasing[i] - 1);
            }
        }
        return ans;
    }
}
