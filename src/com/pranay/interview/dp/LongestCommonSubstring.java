package com.pranay.interview.dp;

import java.util.Arrays;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		String str1 = "acbcdaf";
		String str2 = "zbcdf";
		int len = longestCommonSubstring(str1, str2);
		System.out.println(len);
	}

	private static int longestCommonSubstring(String str1, String str2) {
		String[] s1 = str1.split("");
		String[] s2 = str2.split("");

		int maxLen = 0;

		int[][] T = new int[s2.length+1][s1.length+1];

		for (int i = 1; i<=s2.length; i++) {
			for (int j = 1; j<=s1.length; j++) {
				if (s2[i-1].equals(s1[j-1])) {
					T[i][j] = 1 + T[i-1][j-1];
					maxLen = Math.max(maxLen, T[i][j]);
				} else {
					T[i][j] = 0;
				}
			}
		}

		print2d(T);
		return maxLen;
	}

	private static void print2d(int[][] arr) {
		for (int[] nums: arr) {
			System.out.println(Arrays.toString(nums));
		}
	}
}
