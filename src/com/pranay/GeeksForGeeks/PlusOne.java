package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {8,9};
		int[] res = plusOne(digits);
		System.out.println(Arrays.toString(res));
	}

	private static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i>= 0; i--) {
			digits[i] += 1;
			if (digits[i] <= 9)
				return digits;
			digits[i] = 0;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}

}
