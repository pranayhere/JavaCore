package com.pranay.interview.strings;

/**
 * 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";

        String str = customSortString(S, T);
        System.out.println("Ans : " + str);
    }

    public static String customSortString(String S, String T) {
        int[] count = new int[26];

        for (char ch: T.toCharArray())
            count[ch - 'a']++;

        String ans = "";
        for (char ch: S.toCharArray()) {
            for (int i = 0; i < count[ch - 'a']; i++)
                ans += ch;
            count[ch - 'a'] = 0;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                ans += (char) (i + 'a');
        }
        return ans;
    }
}
