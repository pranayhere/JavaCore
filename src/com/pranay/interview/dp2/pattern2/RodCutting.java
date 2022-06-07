package com.pranay.interview.dp2.pattern2;

/**
 * https://www.educative.io/edpresso/the-rod-cutting-problem
 *
 * Given a rod of length n, and an array that contains the prices of all the pieces smaller than n,
 * determine the maximum profit you could obtain from cutting up the rod and selling its pieces.
 *
 * Suppose that we have a rod of length 5, and an array containing the length(1,2,3 and 4 ) and price(2,5,7 and 8 ) of the pieces.
 * There are various ways to cut the rod into sub-rods, each way results in a certain profit.
 *
 * The answer should be 12 (selling the sub-rods of length 1+2+2 gives a 2+5+5 profit).
 */
public class RodCutting {
    public static void main(String[] args) {
        int L = 5;
        int[] len = {1, 2, 3, 4};
        int[] price = {2, 5, 7, 8};

        RodCutting rc = new RodCutting();
        int maxProfit = rc.rodCutting(len, price, L);
        System.out.println("Max. Profit : " + maxProfit);

        int maxProfit2 = rc.rodCuttingTab(len, price, L);
        System.out.println("tabulation : " + maxProfit2);
    }

    int[][] memo;
    private int rodCutting(int[] len, int[] price, int L) {
        memo = new int[L + 1][len.length + 1];
        return rodCutting(len, price, L, len.length);
    }

    private int rodCutting(int[] len, int[] price, int L, int n) {
        if (n == 0 || L <= 0)
            return 0;

        if (memo[L][n] > 0)
            return memo[L][n];

        // reduce length of bar + reduce n
        // reduce length of bar + don't reduce n
        // don't reduce length of bar, reduce n

        if (len[n - 1] <= L) {
            return memo[L][n] = Math.max(price[n - 1] + rodCutting(len, price, L - len[n - 1], n), rodCutting(len, price, L, n - 1));
        } else
            return memo[L][n] = rodCutting(len, price, L, n - 1);
    }


    private int rodCuttingTab(int[] len, int[] price, int L) {
        int[][] dp = new int[len.length + 1][L + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < len[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - len[i - 1]]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
