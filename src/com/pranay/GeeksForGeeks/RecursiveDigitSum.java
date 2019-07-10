package com.pranay.GeeksForGeeks;

public class RecursiveDigitSum {
	public static void main(String[] args) {
		String n = "861568688536788";
		int k = 100000;
		int ans = superDigit(n, k);
		System.out.println("ans : " + ans);
	}

	private static int superDigit(String n, int k) {
		long sum = getSum(n);
		long str = sum * k;
		int superDigit = recSum(str+"");
		return superDigit;
	}

	private static int recSum(String str) {
		System.out.println("here : " +str);
		int sum = getSum(str);
		if (sum > 9)
			return recSum(sum+"");
		return sum;
	}
	
	private static int getSum(String str) {
		int sum = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i<arr.length; i++) {
			System.out.println("adding : " + arr[i]);
			sum += Integer.parseInt(arr[i] + "");
			System.out.println(sum);
		}
		return sum;
	}
}
