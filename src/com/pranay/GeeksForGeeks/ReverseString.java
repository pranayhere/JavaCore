package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','o'};
        reverseString(s);
    }

    private static void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length - 1;
        while (lo <= hi) {
            char temp = s[hi];
            s[hi] = s[lo];
            s[lo] = temp;

            lo++;
            hi--;
        }

        System.out.println(Arrays.toString(s));
    }
}
