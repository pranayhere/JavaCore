package com.pranay.GeeksForGeeks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestDivisor {
	public static void main(String[] args) {
		int num = 688427155;
		int[] divisors = closestDivisor(num);
		System.out.println(Arrays.toString(divisors));
	}

	public static int[] closestDivisor(int n) {
		int minDiff = Integer.MAX_VALUE;
		int[] ans = new int[2];
		List<Integer> divisor1 = findDivisors(n + 1);
		List<Integer> divisor2 = findDivisors(n + 2);
		System.out.println(divisor1);
		System.out.println(divisor2);

		int lo = 0, hi = divisor1.size() - 1;
		while (lo <= hi) {
			int num1 = divisor1.get(lo);
			int num2 = divisor1.get(hi);
			int expectedMul = n + 1;
			BigInteger mul = new BigInteger(String.valueOf(num1)).multiply(new BigInteger(String.valueOf(num2)));
			int diff = Math.abs(num2 - num1);
			if (mul.compareTo(new BigInteger(String.valueOf(n + 1))) == 0 && diff < minDiff) {
				ans = new int[]{divisor1.get(lo), divisor1.get(hi)};
				minDiff = diff;
			}
			if (mul.compareTo(new BigInteger(String.valueOf(expectedMul))) < 0) {
				lo++;
			} else {
				hi--;
			}
		}

		lo = 0;
		hi = divisor2.size() - 1;
		while (lo <= hi) {
			int num1 = divisor2.get(lo);
			int num2 = divisor2.get(hi);
			int expectedMul = n + 2;
			BigInteger mul = new BigInteger(String.valueOf(num1)).multiply(new BigInteger(String.valueOf(num2)));
			int diff = Math.abs(num2 - num1);
			if (mul.compareTo(new BigInteger(String.valueOf(expectedMul))) == 0 && diff < minDiff) {
				ans = new int[]{divisor2.get(lo), divisor2.get(hi)};
				minDiff = diff;
			}
			if (mul.compareTo(new BigInteger(String.valueOf(expectedMul))) < 0) {
				lo++;
			} else {
				hi--;
			}
		}

		return ans;
	}

	// [2409, 285773]

	public static List<Integer> findDivisors(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=Math.sqrt(n); i++)
		{
			if (n%i == 0)
			{
				if (n/i == i)
					list.add(i);
				else {
					list.add(i);
					list.add(n/i);
				}
			}
		}
		Collections.sort(list);
		return list;
	}
}
