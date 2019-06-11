package com.pranay.GeeksForGeeks;

public class CalculatePossibleCombinationsGS {
	public static void main(String[] args) {
		String inputStr = "2112";
		long ans = calculatePossibleCombinations(inputStr);
		System.out.println(ans);
	}
	
	public static long calculatePossibleCombinations(String inputStr) {
		return countDecoding(inputStr.toCharArray(), inputStr.length());
		
    }

	private static long countDecoding(char[] digits, int n) {
		long count[] = new long[n + 1];
		count[0] = 1;
		count[1] = 1;
		
		for (int i = 2; i<=n; i++) {
			count[i] = 0;
			
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];
			
			if (digits[i -2] == '1' ||
			   (digits[i -2] == '2' && 
			    digits[i -1] < '7'))
				count[i] += count[i-2];
		}
		return count[n];
	}
}
