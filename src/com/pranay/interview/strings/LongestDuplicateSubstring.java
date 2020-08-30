package com.pranay.interview.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1044. Longest Duplicate Substring
 * https://leetcode.com/problems/longest-duplicate-substring/
 */
public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        String S = "pranayyyyyypranayrahulpranayrujutarahulpranayyyyyy";
//        String S = "abcd";
//        String S = "pranaypranay";
        LongestDuplicateSubstring lds = new LongestDuplicateSubstring();
        String ans = lds.longestDupSubstring(S);
        System.out.println(ans);
    }

    Map<Integer, String> hm = new HashMap<>();

    private String longestDupSubstring(String S) {
        if (S.length() == 0)
            return "";

        int lo = 1;
        int hi = S.length();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (findDuplicateOfSize(mid, S))
                lo = mid + 1;
            else
                hi = mid;
        }

        System.out.println(hm);
        System.out.println("Lo : " + lo);
        return hm.getOrDefault(lo - 1, "");
    }

    private boolean findDuplicateOfSize(int m, String s) { // m = size
        Set<String> dups = new HashSet<>();

        String str = "";
        for (int i = 0; i < m; i++)
            str += s.charAt(i);

        dups.add(str);

        for (int i = 1; i < s.length() - m + 1; i++) {
            str = str.substring(1) + s.charAt(i + m - 1);

            if (dups.contains(str)) {
                hm.put(m, str);
                return true;
            }

            dups.add(str);
        }
        return false;
    }
}
