package com.pranay.interview.arrays;

public class GoatLatin {
    public static void main(String[] args) {
        String s = "Each word consists of lowercase and uppercase letters only";
        String ans = toGoatLatin(s);
        System.out.println("Ans : " + ans);
    }

    public static String toGoatLatin(String S) {
        String postfix = "a";
        String vowel = "ma";
        String ans = "";

        for (String s: S.split(" ")) {
            if ("aeiouAEIOU".indexOf(s.charAt(0)) >= 0) {
                s = s + vowel + postfix;
                postfix += 'a';
                ans += s + " ";
            } else {
                char first = s.charAt(0);
                s = s.substring(1) + first + vowel + postfix;
                postfix += 'a';
                ans += s + " ";
            }
        }

        return ans.trim();
    }
}
