package com.pranay.Leetcode30days;

public class LeftmostColumnwithatLeastaOne {
	public static void main(String[] args) {
		int[][] mat = {{0,0},{0,0}};
//		int[][] mat = {{0,0,0,1},{0,0,1,1},{0,1,1,1}};
		int col = leftMostColumnWithOne(mat);
		System.out.println(col);
	}

	private static int leftMostColumnWithOne(int[][] mat) {
		int c = mat[0].length - 1;
		for (int r = 0; r < mat.length && c >= 0;) {
			if (mat[r][c] == 0) {
				r++;
			} else {
				c--;
			}
		}
		return c == mat[0].length - 1 ? -1 : c + 1;
	}
}
