package com.pranay.GeeksForGeeks;

// https://leetcode.com/problems/check-if-it-is-a-straight-line/

public class StraightLine {
	public static void main(String[] args) {
		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.println(checkStraightLine(coordinates));
	}

	public static boolean checkStraightLine(int[][] c) {
		for (int i=0; i<c.length-2; i++) {
			int x1 = c[i][0], y1 = c[i][1];
			int x2 = c[i+1][0], y2 = c[i+1][1];
			int x3 = c[i+2][0], y3 = c[i+2][1];

			System.out.println(x3 + " " + y3);
			int a = x1 * (y2 - y3) +
					x2 * (y3 - y1) +
					x3 * (y1 - y2);

			if (a == 0)
				continue;
			else
				return false;
		}
		return true;
	}
}
