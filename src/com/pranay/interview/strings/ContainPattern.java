package com.pranay.interview.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 1566. Detect Pattern of Length M Repeated K or More Times
 * https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 */
public class ContainPattern {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2};
        int m = 2, k = 2;

        boolean ans = containsPatternShort(arr, m, k);
        System.out.println("Ans : " + ans);
    }

    public static boolean containsPatternShort(int[] arr, int m, int k) {
        int count = 0;

        for (int i = 0; i + m < arr.length; i++) {
            if (arr[i] == arr[i + m])
                count++;
            else
                count = 0;

            if (count == m * (k - 1))
                return true;
        }

        return false;
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        String s = "";
        String str = "";
        String left = "";

        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < m; i++) {
            s += arr[i] + "-";
            str += arr[i] + "-";
        }

        hm.put(s, 1);
        for (int i = 1; i < arr.length - m + 1; i++) {
            left += s.substring(0, s.indexOf("-") + 1);
            s = s.substring(s.indexOf("-") + 1) + arr[i + m - 1] + "-";
            str += arr[i + m - 1] + "-";

            if (str.startsWith(s, left.length() - s.length())) {
                hm.put(s, hm.getOrDefault(s, 0) + 1);
            } else {
                hm.put(s, 1);
            }


            System.out.println(hm);

            if (hm.get(s) >= k) {
                return true;
            }
        }

        return false;
    }
}
