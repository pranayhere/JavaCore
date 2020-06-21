package com.pranay.interview.searching;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        String S = "aabcaabdaab";
        int len = longestRepeatingSubstringBinarySearch(S);
        System.out.println(len);
    }

    private static int longestRepeatingSubstring(String s) {
        Set<String> hs = new HashSet<>();
        int max = 0;

        for (int i = 0; i<=s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (hs.contains(str)) {
                    max = Math.max(max, str.length());
                }
                hs.add(str);
            }
        }

        System.out.println(hs);
        return max;
    }

    private static int longestRepeatingSubstringBinarySearch(String S){
        int n = S.length();

        int left = 1, right = n;
        int L;
        while (left <= right) {
            L = left + (right - left) / 2;
            if (search(L, n, S) != -1)
                left = L + 1;
            else
                right = L - 1;
        }

        return left - 1;
    }

    private static int search(int L, int n, String S) {
        HashSet<String> seen = new HashSet<>();
        String tmp;
        for (int start = 0; start < n - L + 1; start++) {
            tmp = S.substring(start, start + L);
            if (seen.contains(tmp))
                return start;
            seen.add(tmp);
        }
        return -1;
    }

}
