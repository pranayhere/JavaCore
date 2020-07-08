package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		String str = minWindow(S, T);
		System.out.println(str);
	}

	private static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (char ch: t.toCharArray()) {
            dictT.put(ch, dictT.getOrDefault(ch, 0) + 1);
        }

        int required = dictT.size(); // unique char in T
        int l = 0, r = 0;

        int[] ans = {Integer.MAX_VALUE, 0, 0};

        Map<Character, Integer> windowCounts = new HashMap<>();
        int formed = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);
            windowCounts.put(ch, windowCounts.getOrDefault(ch, 0) + 1);

            if (dictT.containsKey(ch) && dictT.get(ch).intValue() == windowCounts.get(ch).intValue()) {
                formed++;
            }

            while (formed == required && l <= r) {
                char rm = s.charAt(l);

                if (r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(rm, windowCounts.get(rm) - 1);
                if (dictT.containsKey(rm) && windowCounts.get(rm) < dictT.get(rm)) {
                    formed--;
                }
                l++;
            }

            r++;
        }

	    return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
