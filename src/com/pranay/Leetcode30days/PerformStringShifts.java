package com.pranay.Leetcode30days;

public class PerformStringShifts {
	public static void main(String[] args) {
//		String s = "abc";
//		int[][] shift = {{0,1},{1,2}};
//
//		String s = "abcdefg";
//		int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
//
//		String s = "googwrbtxjbihxgl"; // Ans: "oogwrbtxjbihxglg"
//		int[][] shift = {{0,8},{0,2},{0,6},{1,15},{0,6},{0,14},{0,10},{0,2},{1,5},{1,16},{0,3},{1,3},{0,0},{1,14},{1,0},{0,3}};

		String s = "yisxjwry";
		int[][] shift = {{1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1}};
		String ans = stringShift(s, shift);
		System.out.println("Ans : " + ans);
	}

	private static String stringShift(String s, int[][] shifts) {
		int right = 0;
		int left = 0;
		int n = s.length();
		for (int[] shift : shifts) {
			int dir = shift[0];
			int steps = shift[1];

			if (dir == 0)
				left += steps;
			else
				right += steps;
		}
		left = left % n;
		right = right % n;
		if (left > right) {
			String l = s.substring(0, (left - right));
			s = s.substring((left - right));
			return s + l;
		}
		String r = s.substring(n  - (right - left), n);
		s = s.substring(0, n  - (right - left));
		return r + s;
	}
}
