package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class FourDivisor {
	public static void main(String[] args) {
		int[] nums = {21,21};
		int sum = sumFourDivisors(nums);
		System.out.println(sum);
	}

	private static int sumFourDivisors(int[] nums) {
		int finalSum = 0;
		for (int j = 0; j<nums.length; j++) {
			List<Integer> list = new ArrayList<>();
			int n = nums[j];
			int sum = 0;
			for (int i=1; i<=Math.sqrt(n); i++) {
				if (n%i == 0) {
					if (n/i == i) {
						list.add(i);
						sum += i;
					}
					else {
						list.add(i);
						list.add(n/i);
						sum += i + (n/i);
					}
				}
			}
			if(list.size() == 4) {
				finalSum += sum;
			}
		}
		return finalSum;
	}
}
