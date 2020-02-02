package com.pranay.GeeksForGeeks;

public class RemovePalindromeSubstring {
	public static void main(String[] args) {
		String s = "ababa";
		int count = removePalindromeSub(s);
		System.out.println(count);
	}

	private static int removePalindromeSub(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int l = 0;
		int h = s.length() - 1;

		while(l < h) {
			if (s.charAt(l) != s.charAt(h)) {
				return 2;
			}
			l++;
			h--;
		}
		return 1;
	}
}
