package com.pranay.interview.dpTusharRoy.pattern3;

/**
 * https://www.youtube.com/watch?v=4Urd0a0BNng
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "aunkcde";

        LongestCommonSubstring lcsobj = new LongestCommonSubstring();
        int len = lcsobj.longestCommonSubsequence(s1, s2);
        System.out.println("Len : " + len);
    }

    private int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1, s2, s1.length() , s2.length());
    }

    private int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + lcs(s1, s2, n - 1, m - 1);
        else
            return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n , m - 1));
    }
}
