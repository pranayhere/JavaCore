package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<Integer> ans = getRow(n);
        System.out.println("Ans : " + ans);
    }

    public static List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans = Arrays.asList(1);
            return ans;
        }

        if (n == 2) {
            ans.clear();
            ans = Arrays.asList(1, 1);
            return ans;
        }

        if (n >= 3) {
            ans = Arrays.asList(1, 2, 1);
        }

        while (n > 3) {
            List<Integer> copy = new ArrayList<>();
            copy.add(1);
            for (int i = 1; i < ans.size(); i++) {
                copy.add(i, ans.get(i) + ans.get(i - 1));
            }
            n--;
            copy.add(1);
            ans = new ArrayList<>(copy);
            copy.clear();
//            System.out.println("Ans : " + ans + " copy : " + copy);
        }

        return ans;
    }
}
