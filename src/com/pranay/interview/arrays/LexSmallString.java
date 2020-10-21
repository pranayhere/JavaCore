package com.pranay.interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class LexSmallString {
    public static void main(String[] args) {
        String s = "5525";
        int a = 9, b = 2;
        LexSmallString lss = new LexSmallString();
        String ans = lss.findLexSmallestString(s, a, b);
        System.out.println("Ans : " + ans);
    }

    Set<String> hs = new HashSet<>();
    String smallest;

    public String findLexSmallestString(String s, int a, int b) {
        smallest = s;
        dfs(s, a, b);
        return smallest;
    }

    private void dfs(String s, int a, int b) {
        if (hs.contains(s))
            return;

        if (s.compareTo(smallest) < 0)
            smallest = s;

        hs.add(s);
        
        dfs(rotate(s, b), a, b);
        dfs(add(s, a), a, b);
    }

    private String add(String s, int add) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i % 2 == 1) {
                int sum = ((c-'0') + add) % 10;
                c = (char) (sum + 48);
            }

            sb.append(c);
        }

        return sb.toString();
    }

    private String rotate(String s, int pos) {
        int len = pos % s.length();
        return s.substring(len) + s.substring(0, len);
    }
}
