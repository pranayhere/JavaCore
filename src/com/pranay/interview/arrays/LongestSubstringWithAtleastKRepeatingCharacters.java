package com.pranay.interview.arrays;

import java.util.Arrays;

public class LongestSubstringWithAtleastKRepeatingCharacters {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;

        int ans = longestSubstring(s, k);
        System.out.println("Ans : "  + ans);
    }

    private static int longestSubstring(String s, int k) {
        int count[] = new int[26];
        int max = 0;

        for (int u = 1; u <= 26; u++) {
            Arrays.fill(count, 0);

            int left = 0, right = 0, unique = 0, kOrMore = 0;

            while (right < s.length()) {
                if (unique <= u) {
                    char ch = s.charAt(right);
                    int idx = (int)ch - 'a';

                    count[idx]++;
                    if (count[idx] == 1)
                        unique++;

                    if (count[idx] >= k)
                        kOrMore++;

                    right++;
                } else {
                    char ch = s.charAt(left);
                    int idx = (int) ch - 'a';

                    count[idx]--;
                    if (count[idx] == 0)
                        unique--;

                    if (count[idx] == k - 1)
                        kOrMore--;

                    left++;
                }

                if (unique == u && kOrMore == unique)
                    max = Math.max(max, right - left);
            }
        }
        return max;
    }
}
