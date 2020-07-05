package com.pranay.interview.arrays;

public class ExpressiveWord {
    public static void main(String[] args) {
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};

        int cnt = expressiveWords(S, words);
        System.out.println("cnt : " + cnt);
    }

    private static int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String w : words) {
            if(check(s, w))
                res++;
        }
        return res;
    }

    private static boolean check(String S, String W) {
        char[] s = S.toCharArray();
        char[] w = W.toCharArray();
        int n = s.length, m = w.length, j = 0;
        for (int i = 0; i < s.length; i++) {
            if (j < m && s[i] == w[j]) j++;
            else if (i > 1 && s[i-2] == s[i - 1] && s[i - 1] == s[i]);
            else if (0 < i && s[i-1] == s[i] && s[i] == s[i + 1]);
            else return false;
        }
        return j == m;
    }
}
