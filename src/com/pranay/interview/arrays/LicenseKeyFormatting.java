package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class LicenseKeyFormatting {
	public static void main(String[] args) {
		String S = "5F3Z-2e-9-w";
		int K = 4;

		String str = licenseKeyFormatting(S, K);
		System.out.println(str);
	}

	private static String licenseKeyFormatting(String s, int k) {
		s = s.replaceAll("-", "").toUpperCase();
		List<String> result = new ArrayList<>();
		int n = s.length();

		if (n == 0) {
			return "";
		}

		int i = n % k;
		if (i > 0) {
			result.add(s.substring(0, i));
		}

		while (i < n) {
			result.add(s.substring(i, i+k));
			i+=k;
		}
		return String.join("-", result);
	}
}
