package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * Input : str1 = "heap", str2 = "pea"
 * Output : Minimum Deletion = 2 and
 *          Minimum Insertion = 1
 * p and h deleted from heap
 * Then, p is inserted at the beginning
 *
 * Assume : str1.len > str2.len
 */
public class MinDeleteAndInsert {
	public static void main(String[] args) {
		String str1 = "heap";
		String str2 = "pea";
		minDeleteAndInserts(str1, str2);
	}

	private static void minDeleteAndInserts(String str1, String str2) {
		String[] s1 = str1.split("");
		String[] s2 = str2.split("");

		int[][] T = new int[s2.length+1][s1.length+1];
		for (int i = 1; i<=s2.length; i++) {
			for (int j = 1; j<=s1.length; j++) {
				if (s1[j-1].equals(s2[i-1])) {
					T[i][j] = 1 + T[i-1][j-1];
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}

		print2d(T);

		int lcs = T[s2.length][s1.length];// length of common subsequence
		System.out.println("Min deletions : " + (s1.length - lcs));
		System.out.println("Min insertions : " + (s2.length - lcs));
	}

	private static void print2d(int[][] arr) {
		for (int[] nums: arr) {
			System.out.println(Arrays.toString(nums));
		}
	}
}