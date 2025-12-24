package com.pranay.interview.dp3.pattern3;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 * 1143. Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        int ans = l.lcs(text1, text2, text1.length(), text2.length());
        System.out.println("Ans: " + ans);
    }

    Map<String, Integer> dp = new HashMap<>();
    public int lcs(String x, String y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        String key = m + "_" + n;
        if (dp.containsKey(key))
            return dp.get(key);

        int len = 0;
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            len = 1 + lcs(x, y, m - 1, n - 1);
        } else {
            len = Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
        }

        dp.put(key, len);
        return len;
    }
}
