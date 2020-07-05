package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed-Explanation-From-O(MNM)-to-O(MN)-by-using-Stack
 */
public class SubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] twoDMatrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        int count2D = numSubmat(twoDMatrix);
        System.out.println("Count 2d : " + count2D);
    }

    private static int numSubmat(int[][] mat) {
        int M = mat.length, N = mat[0].length;

        int res = 0;
        int[] h = new int[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                h[j] = (mat[i][j] == 0 ? 0 : h[j] + 1);
            }
            System.out.println(Arrays.toString(h));
            res += helper(h);
        }
        return res;
    }

    private static int helper(int[] A) {
        int[] sum = new int[A.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            while (!stk.isEmpty() && A[stk.peek()] >= A[i])
                stk.pop();

            if (!stk.isEmpty()) {
                int preIdx = stk.peek();
                sum[i] = sum[preIdx];
                sum[i] += A[i] * (i - preIdx);
            } else {
                sum[i] = A[i] * (i + 1);
            }
            stk.push(i);
        }
        int res = 0;
        for (int s : sum) res += s;

        return res;
    }
}
