package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumInTwoSortedArrays {
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(new Integer[] {1, 2, 4});
		List<Integer> l2 = Arrays.asList(new Integer[] {0, 1, 3});
		int sum = 5;
		boolean ans = isPresent(sum, l1, l2);
		System.out.println(ans);

	}

	public  static  boolean isPresent(int sum, List<Integer> l1, List<Integer> l2) {
		int l = 0;
		int r = l2.size() - 1;
		int m = l1.size();
		int n = l2.size();

		while (l < m && r >= 0) {
			if ((l1.get(l) + l2.get(r)) == sum)
			{
				l++; r--;
				return true;
			}

			else if ((l1.get(l) + l2.get(r)) < sum)
				l++;
			else
				r--;
		}
		return false;
	}
}
