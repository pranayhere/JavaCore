package com.pranay.Leetcode30days;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		int n = 19;
		boolean ans = isHappy(n);
		System.out.println(ans);
	}

	private static boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();
		while (n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getNext(n);
		}
		return n == 1;
	}

	private static int getNext(int n) {
		char[] nums = Integer.toString(n).toCharArray();
		int sum = 0;
		for (char ch: nums) {
			int num = Character.getNumericValue(ch);
			sum += num * num;
		}
		return sum;
	}

	public boolean isHappyFailed(int n) { // doesn't detect cycle in the code... try with input 2
		System.out.println(n);
		if (n == 1) {
			return true;
		}
		char[] nums = Integer.toString(n).toCharArray();
		int sum = 0;
		for (char ch: nums) {
			int num = Character.getNumericValue(ch);
			sum += num * num;
		}
		return isHappy(sum);
	}
}
