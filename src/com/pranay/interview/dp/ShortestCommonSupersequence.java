package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: "geeke"
 *
 * Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 * Output:  "AGXGTXAYB"
 *
 * ANS : Length of the shortest supersequence  = (Sum of lengths of given two strings) -
 *                                         (Length of LCS of two given strings)
 */


public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "AGXGTXAYB";
		int len = shortestCommonSupersequence(str1, str2);
		System.out.println(len);
	}

	private static int shortestCommonSupersequence(String str1, String str2) {
		String[] s1 = str1.split("");
		String[] s2 = str2.split("");

		int[][] T = new int[s1.length + 1][s2.length + 1];
		for(int i = 1; i<=s1.length; i++) {
			for (int j = 1; j<=s2.length; j++) {
				if (s1[i-1].equals(s2[j-1])) {
					T[i][j] = 1 + T[i-1][j-1];
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		print2d(T);
		return s1.length + s2.length - T[s1.length][s2.length];
	}

	private static void print2d(int[][] arr) {
		for (int[] nums: arr) {
			System.out.println(Arrays.toString(nums));
		}
	}
}
