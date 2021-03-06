package com.pranay.interview.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 862. Shortest Subarray with Sum at Least K
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * Explanation
 * https://www.youtube.com/watch?v=_JDpJXzTGbs
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
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

        int[] ps = new int[N + 1]; // store prefix sum
        for (int i = 0; i < N; i++)
            ps[i + 1] = ps[i] + A[i];

        // [0, 2, 1, 3, 4]
        System.out.println(Arrays.toString(ps));

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            System.out.println(d);
            while (d.size() > 0 && ps[i] - ps[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());

            while (d.size()> 0 && ps[i] <= ps[d.getLast()]) {
                System.out.println(ps[i] + " - " + ps[d.getLast()]);
                d.pollLast();
            }

            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
}

//        [0, 2, 1, 3, 4]
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