package com.pranay.interview.dp3.pattern3;

/**
 * Given two strings s1 and s2. The task is to remove or insert the minimum number of
 * characters from/in s1 to transform it into s2. It could be possible that the same
 * character needs to be removed from one point of s1 and inserted into another point.
 *
 * Examples :
 *
 * Input: s1 = "heap", s2 = "pea"
 * Output: 3
 * Explanation: 'p' and 'h' deleted from heap. Then, 'p' is inserted at the beginning.
 * Input : s1 = "geeksforgeeks", s2 = "geeks"
 * Output: 8
 * Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".
 */
public class MinInsertionAndDeletion {
    public static void main(String[] args) {
        String s1 = "heap", s2 = "pea";

        MinInsertionAndDeletion m = new MinInsertionAndDeletion();
        int ans = m.minInsAndDel(s1, s2);
        System.out.println("Ans: " + ans);
    }

    private int minInsAndDel(String s1, String s2) {
        int lcs = lcs(s1, s2, s1.length(), s2.length());
        return (s1.length() - lcs) + (s2.length() - lcs);
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
