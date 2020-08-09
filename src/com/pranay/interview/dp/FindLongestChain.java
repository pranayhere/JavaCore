package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        int length = findLongestChain(pairs);
        System.out.println("Length of longest chain : " + length);
    }

    private static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(dp[i], max);
        return max;
    }
}
