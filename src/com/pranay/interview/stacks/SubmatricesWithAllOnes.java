package com.pranay.interview.stacks;

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

//    O(m * n * n)
    private static int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] height = new int[n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                int min = height[j];
                for (int k = j; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    res += min;
                }
            }
        }

        return res;
    }


//    O(M * N)
    public int numSubmatStack(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] height = new int[n];
        int res = 0;

        for (int i = 0; i<m; i++) {
            Stack<int[]> stk = new Stack<>();
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                int sum = 0;
                while (!stk.isEmpty() && height[stk.peek()[0]] >= height[j])
                    stk.pop();

                if (!stk.isEmpty())
                    sum += height[j] * (j - stk.peek()[0]) + stk.peek()[1];
                else
                    sum += height[j] * (j + 1);

                stk.push(new int[]{j, sum});
                res += sum;
            }
        }
        return res;
    }

}
