package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 1592. Rearrange Spaces Between Words
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 */
public class ReorderSpaces {
    public static void main(String[] args) {
        String text = "a b c ";
        String ans = reorderSpaces(text);
        System.out.println("Ans : " + ans);
    }


    public static String reorderSpaces(String text) {
        int spaces = 0;
        for (char ch: text.toCharArray())
            if (ch == ' ')
                spaces++;

        String[] str = text.trim().split("\\s+");

        if (str.length == 1 && spaces > 0) {
            String sp = "";
            for (int i = 0; i < spaces; i++)
                sp += " ";
            return str[0] + sp;
        }


        if (str.length == 1)
            return str[0];

        System.out.println(Arrays.toString(str));

        int count = spaces / (str.length - 1);
        String extra = "";
        if ((str.length - 1) * count < spaces)
            extra = " ";

        String sp = "";
        for (int i = 0; i < count; i++)
            sp += " ";

        String res = "";
        for (int i = 0; i < str.length - 1; i++) {
            res += str[i] + sp;
        }

        res += str[str.length - 1] + extra;
        return res;
    }
}
