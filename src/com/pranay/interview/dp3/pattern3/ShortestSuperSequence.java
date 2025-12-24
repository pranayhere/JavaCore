package com.pranay.interview.dp3.pattern3;

/**
 * Given two strings s1 and s2, the task is to find the length of the shortest
 * string that has both s1 and s2 as subsequences.
 *
 * Examples:
 *
 * Input: s1 = “geek”, s2 = “eke”
 * Output: 5
 * Explanation: String “geeke” has both string “geek” and “eke” as subsequences.
 *
 *
 * Input: s1 = “AGGTAB”, s2 = “GXTXAYB”
 * Output:  9
 * Explanation: String “AGXGTXAYB” has both string “AGGTAB” and “GXTXAYB” as subsequences.
 */
public class ShortestSuperSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";

        ShortestSuperSequence ss = new ShortestSuperSequence();
        int ans = ss.shortestSuperSequence(s1, s2);
        System.out.println("Ans: " + ans);
    }

    private int shortestSuperSequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int lcs = lcs(s1, s2, m, n);
        return m + n - lcs;
    }

    private int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }
}
