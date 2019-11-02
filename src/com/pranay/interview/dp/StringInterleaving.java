package com.pranay.interview.dp;

import java.util.Arrays;

public class StringInterleaving {
	public static void main(String[] args) {
		String str1 = "axy";
		String str2 = "aab";
		String str3 = "aaxaby";
		boolean isInterleaving = stringInterleaving(str1, str2, str3);
		System.out.println(isInterleaving);
	}

	private static boolean stringInterleaving(String str1, String str2, String str3) {
		String[] s1 = str1.split("");
		String[] s2 = str2.split("");
		String[] s3 = str3.split("");

		if(s1.length + s2.length != s3.length){
			return false;
		}

		boolean[][] T = new boolean[s1.length + 1][s2.length + 1];

		T[0][0] = true;

		for (int i = 1; i<=s1.length; i++) {
			if (s1[i-1].equals(s3[i-1]))
				T[i][0] = T[i-1][0];
		}

		for (int j = 1; j<=s2.length; j++) {
			if (s2[j-1].equals(s3[j-1])) {
				T[0][j] = T[0][j-1];
			}
		}

		for (int i = 1; i<=s1.length; i++) {
			for (int j = 1; j<=s2.length; j++) {
				int l = i + j - 1;
				if (s1[i-1].equals(s3[l]))
					T[i][j] = T[i-1][j];
				else if (s2[j-1].equals(s3[l]))
					T[i][j] = T[i][j-1];
				else
					T[i][j] = false;
			}
		}

		print2d(T);
		return T[s1.length][s2.length];
	}

	private static void print2d(boolean[][] t) {
		for (boolean[] arr: t) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
