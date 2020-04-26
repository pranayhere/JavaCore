package com.pranay.Leetcode30days;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text2 = "abcde", text1 = "ace";
        int len = longestCommonSubsequence(text1, text2);
        System.out.println("Length of longest common subsequence : " + len);
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        String[] arr1 = text1.split("");
        String[] arr2 = text2.split("");

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i<dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i-1].equals(arr2[j-1])) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        print2d(dp);

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void print2d(int[][] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
