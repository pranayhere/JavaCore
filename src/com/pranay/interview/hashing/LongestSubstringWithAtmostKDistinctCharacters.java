package com.pranay.interview.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * TestCases
 * "eceba"
 * 2
 * "aa"
 * 1
 * "a"
 * 2
 * "aa"
 * 2
 * "nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy"
 * 25
 */
public class LongestSubstringWithAtmostKDistinctCharacters {
    public static void main(String[] args) {

        String s = "nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy";
        int k = 24;
        LongestSubstringWithAtmostKDistinctCharacters l = new LongestSubstringWithAtmostKDistinctCharacters();
        int len = l.lengthOfLongestSubstringKDistinct(s, k);
        System.out.println("Len : " + len);
    }

    Map<Character, Integer> hm = new HashMap<>();

    private int lengthOfLongestSubstringKDistinct(String s, int k) {
        int lo = 0;
        int hi = 0;

        int len = 0;

        if (k > s.length()) {
            return s.length();
        }

        while (hi < s.length()) {
            char ch = s.charAt(hi);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            if (hm.size() == k) {
                len = Math.max(len, hi - lo + 1);
            }

            if (hm.size() > k) {
                char rm = s.charAt(lo);
                int cnt = hm.get(rm);
                if (cnt == 1)
                    hm.remove(rm);
                else
                    hm.put(rm, cnt - 1);

                lo++;
            }
            hi++;
        }
        System.out.println(hm);
        return len;
    }


}
