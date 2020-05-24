package com.pranay.GeeksForGeeks;

public class MaxVowelsInSubString {
    public static void main(String[] args) {
        String s = "aeiou";
        int k = 2;

        int len = maxVowels(s, k);
        System.out.println("Len : " + len);
    }

    private static int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                count++;
            }
            if (i >= k) {
                char rm = s.charAt(i - k);
                if (isVowel(rm)) {
                    count--;
                }
            }

            max = Math.max(count, max);
        }

        return max;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
