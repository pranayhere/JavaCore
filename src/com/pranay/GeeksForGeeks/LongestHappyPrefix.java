package com.pranay.GeeksForGeeks;

public class LongestHappyPrefix {
	public static void main(String[] args) {
		String s = "level";
		String out = longestPrefix(s);
		System.out.println(out);
	}

	private static String longestPrefix(String s) {
		int mod = 1000000007;
		int a = 31;
		int n = s.length();
		long sHash = 0;
		long rHash = 0;
		long p = 1;
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			int c = s.charAt(i) - 'a';
			int rc = s.charAt(n - 1 - i) - 'a';
			sHash = (sHash * a % mod + c) % mod;
			rHash = (rHash + rc * p % mod) % mod;
			p = p * a % mod;
			if (sHash == rHash) {
				res = i + 1;
			}
		}
		return s.substring(0, res);
	}
}
