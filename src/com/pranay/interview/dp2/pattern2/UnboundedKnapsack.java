package com.pranay.interview.dp2.pattern2;

/**
 * Unbounded Knapsack (Repetition of items allowed)
 *
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti,
 * we need to calculate minimum amount that could make up this quantity exactly.
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 *
 * Input : W = 100
 *        val[]  = {1, 30}
 *        wt[] = {1, 50}
 * Output : 100
 * There are many ways to fill knapsack.
 * 1) 2 instances of 50 unit weight item.
 * 2) 100 instances of 1 unit weight item.
 * 3) 1 instance of 50 unit weight item and 50
 *    instances of 1 unit weight items.
 * We get maximum value with option 2.
 *
 * Input : W = 8
 *        val[] = {10, 40, 50, 70}
 *        wt[]  = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 */
public class UnboundedKnapsack {

    public static void main(String[] args) {
//        int[] wt = {1, 50};
//        int[] val = {1, 30};
//        int W = 100;

        int[] wt  = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};
        int W = 8;

        UnboundedKnapsack uk = new UnboundedKnapsack();
        int maxVal = uk.knapsack(wt, val, W);
        System.out.println("Max profit : " + maxVal);

        int ans = uk.knapsackTab(wt, val, W);
        System.out.println("Tabulation: " + ans);
    }

    int[][] dp;
    public int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        dp = new int[n + 1][W + 1];

        return knapsackMemo(wt, val, W, n);
    }

    public int knapsackMemo(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W <= 0)
            return 0;

        if (dp[n][W] > 0)
            return dp[n][W];

        if (wt[n - 1] <= W)
            return dp[n][W] = Math.max(val[n - 1] + knapsackMemo(wt, val, W - wt[n - 1], n), knapsackMemo(wt, val, W, n - 1));
        else
            return dp[n][W] = knapsackMemo(wt, val, W, n - 1);
    }

    public int knapsackTab(int[] wt, int[] val, int W) {
        int[][] dp = new int[wt.length + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < wt[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
