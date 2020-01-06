package com.pranay.interview.arrays;

public class DecryptString {
	public static void main(String[] args) {
		String s = "10#11#12";
		String ans = freqAlphabets(s);
		System.out.println(ans);
	}

	private static String freqAlphabets(String str) {
		while (str.length() != 0) {
			if (str.contains("#")) {
				String[] arr = str.split("#",2);

			}
		}
		return null;
	}
}
