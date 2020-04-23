package com.pranay.Leetcode30days;

public class BitWiseAndOfRange {
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
		int res = rangeBitwiseAnd(m, n);
		System.out.println("Result : " + res);
	}

	private static int rangeBitwiseAnd(int m, int n) {
		int res = m;
		for (int i = m+1; i<=n; i++) {
			res ^= i;
		}
		return res;
	}
}
