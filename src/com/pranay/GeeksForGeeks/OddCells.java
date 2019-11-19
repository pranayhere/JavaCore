package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class OddCells {
	public static void main(String[] args) {
		int n = 2, m = 3;
		int[][] indices = {{0,1},{1,1}};
		int count = oddCells(n, m, indices);
		System.out.println(count);
	}

	private static int oddCells(int n, int m, int[][] indices) {
		int[][] arr = new int[n][m];
		for (int[] index : indices) {
			int row = index[0];
			int col = index[1];
			for(int i = 0; i<m; i++) {
				arr[row][i] = arr[row][i] + 1;
			}

			for(int i = 0; i < n; i++) {
				arr[i][col] = arr[i][col] + 1;
			}
		}

		int count = 0;

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (arr[i][j] % 2 != 0)
					count++;
			}
		}
//		print2d(arr);
		return count;
	}

	private static void print2d(int[][] arr) {
		for (int[] a: arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
