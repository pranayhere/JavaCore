package com.pranay.GeeksForGeeks;

public class maximum69Number {
	public static void main(String[] args) {
		int num = 9669;
		int ans = maximum69Number(num);
		System.out.println(ans);
	}

	private static int maximum69Number(int num) {
		return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
	}
}
