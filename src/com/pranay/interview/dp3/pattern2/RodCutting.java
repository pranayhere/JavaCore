package com.pranay.interview.dp3.pattern2;

import java.util.Arrays;

/**
 * https://www.educative.io/edpresso/the-rod-cutting-problem
 *
 * Given a rod of length n, and an array that contains the prices of all the pieces smaller than n,
 * determine the maximum profit you could obtain from cutting up the rod and selling its pieces.
 *
 * Suppose that we have a rod of length 5, and an array containing the length(1,2,3 and 4 ) and
 * price(2,5,7 and 8 ) of the pieces.
 * There are various ways to cut the rod into sub-rods, each way results in a certain profit.
 *
 * The answer should be 12 (selling the sub-rods of length 1+2+2 gives a 2+5+5 profit).
 */

public class RodCutting {
    public static void main(String[] args) {
        int L = 5;
        int[] len = {1, 2, 3, 4};
        int[] price = {2, 5, 7, 8};

        RodCutting r = new RodCutting();
        int maxProfit = r.rodCutting(len, price, L);
        System.out.println("Max Profit: "+ maxProfit);
    }

    int[][] dp;
    private int rodCutting(int[] len, int[] price, int L) {
        dp = new int[L + 1][len.length + 1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return rodCutting(len, price, L, len.length);
    }

    private int rodCutting(int[] len, int[] price, int L, int n) {
        if (n == 0 || L == 0)
            return 0;

        if (dp[L][n] >= 0)
            return dp[L][n];

        if (len[n - 1] <= L)
            return dp[L][n] = Math.max(price[n - 1] + rodCutting(len, price, L - len[n - 1], n - 1),
                    rodCutting(len, price, L, n - 1));
        else
            return dp[L][n] = rodCutting(len, price, L, n - 1);
    }
}
