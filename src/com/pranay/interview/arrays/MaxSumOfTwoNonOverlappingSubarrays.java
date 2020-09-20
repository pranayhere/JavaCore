package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 1031. Maximum Sum of Two Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class MaxSumOfTwoNonOverlappingSubarrays {
    public static void main(String[] args) {
        int[] A = {3,8,1,3,2,1,8,9,0};
        int L = 3, M = 2;

        int sum = maxSumTwoNoOverlap(A, L, M);
        System.out.println("Max Sum : " + sum);
    }

    private static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for (int i = 1; i < A.length; ++i)
            A[i] += A[i - 1];

        System.out.println(Arrays.toString(A));

        int res = A[L + M - 1];
        int Lmax = A[L - 1];
        int Mmax = A[M - 1];

        for (int i = M + L; i < A.length; ++i) {
            Lmax = Math.max(Lmax, A[i - M] - A[i - M - L]);
            Mmax = Math.max(Mmax, A[i - L] - A[i - M - L]);

            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
            System.out.println(res + " - " + Lmax + " - " + Mmax);
        }
        return res;
    }

//    for (int i = 1; i < A.length; ++i)
//    A[i] += A[i - 1];
//    int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
//        for (int i = L + M; i < A.length; ++i) {
//        Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
//        Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
//        res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
//    }
//        return res;
}
