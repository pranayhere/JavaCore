package com.pranay.interview.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "zbcdf";
		int len = longestCommonSubsequence(str1, str2);
		System.out.println(len);
	}

	private static int longestCommonSubsequence(String str1, String str2) {
		String[] s1 = str1.split("");
		String[] s2 = str2.split("");

		int[][] T = new int[s2.length + 1][s1.length + 1];
		for (int i=1; i<=s2.length; i++) {
			for (int j=1; j<=s1.length; j++) {
				if (s1[j-1].equals(s2[i-1])) {
					T[i][j] = 1 + T[i-1][j-1];
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		print2d(T);
		return T[s2.length][s1.length];
	}

	private static void print2d(int[][] arr) {
		for (int[] nums: arr) {
			System.out.println(Arrays.toString(nums));
		}
	}
}
