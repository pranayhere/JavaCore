package com.pranay.interview.arrays.permutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
//        String S = "a1b2";
        String S = "3z4";
        List<String> ans = letterCasePermutation(S);
        System.out.println("Ans : " + ans);
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if (s.matches("-?\\d+(\\.\\d+)?")) {
            res.add(s);
            return res;
        }
        permute(s, 0, res);
        return res;
    }

    public static void permute(String s, int idx, List<String> res) {
        if (idx == s.length())
            return;

        if (Character.isDigit(s.charAt(idx)))
            permute(s, idx + 1, res);
        else {
            char ch = s.charAt(idx);
            char newCh = Character.isUpperCase(s.charAt(idx)) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
            String newW = s.substring(0, idx) + newCh + s.substring(idx + 1);
            res.add(newW);
            res.add(s);
            permute(s, idx + 1, res);
            permute(newW, idx + 1, res);
        }
    }
}
