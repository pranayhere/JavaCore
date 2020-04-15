package com.pranay.interview.recursion;

public class GCD {
	public static void main(String[] args) {
		int x = 156;
		int y = 36;
		int ans = gcd(x, y);
		System.out.println("Ans : " + ans);
	}

	private static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}
}
