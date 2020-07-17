package com.pranay.interview.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Explanation
 * https://www.youtube.com/watch?v=_JDpJXzTGbs
 *
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/submissions/
 */

public class ShortestSubarrayWithSumAtleastK {
    public static void main(String[] args) {
        int[] A = {2,-1,2,1};
        int K = 3;

//        int[] A = {84,-37,32,40,95};
//        int K = 167;

        int size = shortestSubarray(A, K);
        System.out.println("Shortest Subarray : " + size);
    }

    private static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int res = N + 1;

        int[] B = new int[N + 1]; // store prefix sum
        for (int i = 0; i < N; i++)
            B[i + 1] = B[i] + A[i];

        System.out.println(Arrays.toString(B));
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size()> 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
            System.out.println(d);
        }
        return res <= N ? res : -1;
    }
}

//[0, 2, 1, 3, 4]
//        [0]
//        [0, 1]
//        [0, 1, 2]
//        [1, 2, 3]
//        [1, 2, 3, 4]


//        [0]
//        [0, 1]
//        [0, 2]
//        [2, 3]
//        [3, 4]