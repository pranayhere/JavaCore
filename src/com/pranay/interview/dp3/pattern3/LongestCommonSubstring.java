package com.pranay.interview.dp3.pattern3;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "zbcdgh";

        LongestCommonSubstring ls = new LongestCommonSubstring();
        int ans = ls.longestCommonSubstring(s1, s2, s1.length(), s2.length(), 0);
        System.out.println("Ans: " + ans);
    }

    private int longestCommonSubstring(String s1, String s2, int m, int n, int count) {
        if (m == 0 || n == 0)
            return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return longestCommonSubstring(s1, s2, m - 1, n - 1, count + 1);
        else
            return Math.max(count, Math.max(longestCommonSubstring(s1, s2, m - 1, n, 0), longestCommonSubstring(s1, s2, m, n - 1, 0)));
    }
}
