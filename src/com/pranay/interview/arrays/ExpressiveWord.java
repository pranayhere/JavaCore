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

    private static boolean check(String s, String w) {
        int i = 0;
        int j = 0;
        while(j < w.length() && i < s.length()) {
            int counts = 1;
            while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                counts++;
                i++;
            }
            int countw = 1;
            while(j+1 < w.length() && w.charAt(j) == w.charAt(j+1)) {
                countw++;
                j++;
            }
            if(i< s.length() && j< w.length() && s.charAt(i) == w.charAt(j)) {
                if(counts == countw || (counts > 2 && countw < counts)){
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        return i==s.length() && j==w.length();
    }
}
