package com.pranay.interview.strings;

import java.util.Arrays;

/**
 * 1663. Smallest String With A Given Numeric Value
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */

public class SmallestStringWithGivenNumericValue {
    public static void main(String[] args) {
        int n = 5, k = 73;
        String ans = getSmallestString(n, k);
        System.out.println("Ans : " + ans);
    }

    private static String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        for (int i = n - 1; i >= 0; i--) {
            k -= i;

            if (k < 0)
                break;

            if (k >= 26) {
                arr[i] = 'z';
                k = k - 26;
            } else {
                arr[i] = (char) (k + 97 - 1);
                k -= arr[i] - 'a' + 1;
            }

            k += i;
        }

        return String.valueOf(arr);
    }
}
