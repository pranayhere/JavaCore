package com.pranay.GeeksForGeeks;

import java.util.*;

public class LexLastSubstring {
    public static void main(String[] args) {
        String s = "abab";
        String str = lastSubstring(s);
        System.out.println(str);
    }

    private static String lastSubstring(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++)
                list.add(s.substring(i, j));
        }

        Collections.sort(list);
        System.out.println(list);
        return list.get(list.size() - 1);
    }
}
