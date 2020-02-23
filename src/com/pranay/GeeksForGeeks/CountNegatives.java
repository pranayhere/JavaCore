package com.pranay.GeeksForGeeks;

public class CountNegatives {
	public static void main(String[] args) {
		int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//		int[][] grid = {{3,2},{1,0}};
//		int[][] grid = {{1,-1},{-1,-1}};
//		int[][] grid = {{-1}};
		int count = countNegatives(grid);
		System.out.println(count);
	}

	private static int countNegatives(int[][] grid) {
		int n = grid[0].length;
		int m = grid.length;

		int r = m-1;
		int c = 0;

		int count = 0;
		while (r >= 0 && c < n) {
			if (grid[r][c] < 0) {
				count += (n - c);
				r--;
			} else {
				c++;
			}
		}
		return count;
	}

}
