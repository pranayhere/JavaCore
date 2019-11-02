package com.pranay.interview.dp;

import java.util.Arrays;

public class MinimumEditDistance {
	public static void main(String[] args) {
		String str1 = "azced";
		String str2 = "abcdef";
		int count = minEditDistance(str1, str2);
		System.out.println(count);
	}

	private static int minEditDistance(String str1, String str2) {
		String[] s1 = str1.split("");
		String[] s2 = str2.split("");
		int[][] T = new int[s1.length + 1][s2.length + 1];

		for (int i = 0; i<=s1.length; i++) {
			T[i][0] = i;
		}

		for (int i = 0; i<=s2.length; i++) {
			T[0][i] = i;
		}

		for (int i = 1; i<=s1.length; i++) {
			for (int j = 1; j<=s2.length; j++) {
				if (s1[i-1].equals(s2[j-1])) {
					T[i][j] = T[i-1][j-1];
				} else {
					T[i][j] = 1 + getMin(T[i-1][j], T[i][j-1], T[i-1][j-1]);
				}
			}
		}
		print2d(T);
		return T[s1.length][s2.length];
	}

	private static int getMin(int a, int b, int c) {
		if (a < b && a < c)
			return a;
		else if (b < a && b < c)
			return b;
		else
			return c;
	}

	private static void print2d(int[][] arr) {
		for (int[] nums: arr) {
			System.out.println(Arrays.toString(nums));
		}
	}
}
