package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 936. Stamping The Sequence
 * https://leetcode.com/problems/stamping-the-sequence/
 */

public class StampingTheSequence {
    public static void main(String[] args) {
        String stamp = "abca", target = "aabcaca";
        int[] ans = movesToStamp(stamp, target);
        System.out.println("ANS : " + Arrays.toString(ans));
    }

    public static int[] movesToStamp(String stamp, String target) {
        List<Integer> ans = new ArrayList<>();
        int len = target.length();
        char[] curr = target.toCharArray();
        char[] targetStr = new char[len];
        Arrays.fill(targetStr, '*');

        while (!Arrays.equals(curr, targetStr)) {
            int stampIdx = fetchIndex(stamp, curr);
            if (stampIdx >= 0)
                update(curr, stampIdx, stamp);
            else
                return new int[0];

            ans.add(0, stampIdx);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private static int fetchIndex(String stamp, char[] curr) {
        for (int i = 0; i < curr.length; i++) {
            int s = 0;
            int c = i;

            boolean isNonStar = false;
            while (s < stamp.length() && c < curr.length && (curr[c] == '*' || stamp.charAt(s) == curr[c])) {
                if (curr[c] != '*')
                    isNonStar = true;

                s++;
                c++;
            }

            if (isNonStar && s == stamp.length())
                return i;
        }
        return -1;
    }

    private static void update(char[] curr, int stampIdx, String stamp) {
        for (int i = 0; i < stamp.length(); i++) {
            curr[i + stampIdx] = '*';
        }
    }
}
