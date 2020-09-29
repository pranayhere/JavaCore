package com.pranay.interview.graphAll.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 132. Palindrome Partitioning II
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);
        System.out.println("palindrome partitions : " + ans);
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    public static void dfs(String s, int idx, List<String> curr, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                String sub = s.substring(idx, i + 1);
                curr.add(sub);
                dfs(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);                
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
}
