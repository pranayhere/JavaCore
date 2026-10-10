package com.pranay.cses.dp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class DiceCombinations {
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

    static final int MOD = 1_000_000_007;
    static long[] memo;

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);

//        int total = fs.nextInt();
//        memo = new long[total + 1];
//        Arrays.fill(memo, -1);

//        long ans = diceCombo(total);

        int n = fs.nextInt();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= n; sum++) {
            for (int face = 1; face <= 6 && face <= sum; face++) {
                dp[sum] += dp[sum - face];
                if (dp[sum] >= MOD) {
                    dp[sum] %= MOD;
                }
            }
        }

        System.out.println(dp[n]);
//        System.out.println(ans);
    }

    public static long diceCombo(int total) {
        if (total == 0) return 1;
        if (total < 0) return 0;
        if (memo[total] != -1) return memo[total];

        long ans = 0;
        for (int face = 1; face <= 6; face++) {
            ans = (ans + diceCombo(total - face)) % MOD;
        }

        memo[total] = ans;
        return ans;
    }
}
