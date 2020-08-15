package com.pranay.interview.slidingWindow;

import java.util.Arrays;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int len = characterReplacement(s, k);
        System.out.println("Len : " + len);

        String s1 = null;

        if (s1.equalsIgnoreCase("test")) {
            System.out.println("ans ::");
        }
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];

        int start = 0;
        int maxCount = 0;
        int maxLen = 0;

        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        System.out.println(Arrays.toString(count));
        return maxLen;
    }
}
