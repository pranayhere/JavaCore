//package com.pranay.cses.dp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CoinCombinations2 {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int sum = fs.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = fs.nextInt();
        }

//        memo = new Integer[sum + 1][n + 1];
//        int ways = coinDistinctWays(coins, sum, n);
//        System.out.println(ways);

        int ways2 = coinDistinctWaysTabu(coins, sum, n);
        System.out.println(ways2);
    }

    static final int MOD = 1_000_000_007;
    static Integer[][] memo;

    private static int coinDistinctWaysTabu(int[] coins, int x, int n) {
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int sum = coin; sum <= x; sum++) {
                dp[sum] += dp[sum - coin];
                if (dp[sum] >= MOD)
                    dp[sum] -= MOD;
            }
        }

        return dp[x];
    }

    private static int coinDistinctWays(int[] coins, int sum, int n) {
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (memo[sum][n] != null) {
            return memo[sum][n];
        }

        if (sum >= coins[n - 1]) {
            memo[sum][n] = (coinDistinctWays(coins, sum - coins[n - 1], n) + coinDistinctWays(coins, sum, n - 1)) % MOD;
        } else {
            memo[sum][n] = coinDistinctWays(coins, sum, n - 1);
        }

        return memo[sum][n];
    }
}
